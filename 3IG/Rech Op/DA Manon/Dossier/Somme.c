#include "Header.h"

void calculTotaux(FileAttente *ptrDebOrdinaire, FileAttente *ptrDebAbsolu, FileAttente *ptrDebRelatif, int station, Station tabStations[], int *nbOrdinaires, int *nbRelatives, int *nbAbsolus, int *nbStationTot, int tempsService, FILE *(*fichier))
{
	int iStation = 0;
	if (station == SMIN && tempsService < 20) {
		fprintf(*fichier, "      tableau de station en fin de minute: \n");
	}
	while (iStation < station)
	{
		if (tabStations[iStation].dureeService > 0)
		{
			(*nbStationTot)++;

			if (tabStations[iStation].priorite == 1)
			{
				(*nbAbsolus)++;
			}
			if (tabStations[iStation].priorite == 2)
			{
				(*nbRelatives)++;
			}
			if (tabStations[iStation].priorite == 3)
			{
				(*nbOrdinaires)++;
			}
			tabStations[iStation].dureeService--;
			if (station == SMIN && tempsService < 20) {
				fprintf(*fichier, "type client = %s    duree de service restante = %d\n", (tabStations[iStation].priorite == 1)? "Absolu": (tabStations[iStation].priorite == 2)? "Relatif":"Ordinaire" , tabStations[iStation].dureeService);
			}
		}
		iStation++;
	}

	if (station == SMIN && tempsService < 20) {
		if (ptrDebAbsolu != NULL || ptrDebOrdinaire != NULL || ptrDebRelatif != NULL)
			fprintf(*fichier, "      files d'attente en fin de minute : \n");
	}

	FileAttente * ptr = ptrDebAbsolu;
	while (ptr != NULL)
	{
		if (station == SMIN && tempsService < 20) {
			fprintf(*fichier, "type client = Absolu    duree de service restante = %d\n", ptr->dureeService);
		}
		(*nbAbsolus)++;
		ptr = ptr->ptrSuiv;
	}

	ptr = ptrDebRelatif;
	while (ptr != NULL)
	{
		if (station == SMIN && tempsService < 20) {
			fprintf(*fichier, "type client = Relatif    duree de service restante = %d\n", ptr->dureeService);
		}
		(*nbRelatives)++;
		ptr = ptr->ptrSuiv;
	}

	ptr = ptrDebOrdinaire;
	while (ptr != NULL)
	{
		if (station == SMIN && tempsService < 20) {
			fprintf(*fichier, "type client = Ordinaire    duree de service restante = %d\n", ptr->dureeService);
		}
		(*nbOrdinaires)++;
		ptr = ptr->ptrSuiv;
	}
	if (station == SMIN && tempsService < 20) {
		fprintf(*fichier, "      cout total = %lf\n", sommeCout(*nbOrdinaires, *nbRelatives, *nbAbsolus, *nbStationTot, station, NULL));
	}
}
double sommeCout(int nbOrdinaires, int nbRelatives, int nbAbsolus, int nbStationsTotal, int station, FILE *(*fichier))
{
	double coutTotal, coutStationsLibres, coutStationsOccupes;
	double totOrdinaires, totAbsolus, totRelatives;
	double stationsLibres;

	totOrdinaires = nbOrdinaires * COUT_ORDINAIRE / 60;
	totAbsolus = nbAbsolus * COUT_ABSOLU / 60;
	totRelatives = nbRelatives * COUT_RELATIF / 60;
	stationsLibres = station * TEMPS_SERVICE - nbStationsTotal;
	coutStationsLibres = stationsLibres * COUT_STATION_LIBRE / 60;
	coutStationsOccupes = nbStationsTotal * COUT_STATION_OCCUPE / 60;
	if (fichier != NULL) {
		fprintf(*fichier, "		cout pour les ordinaires : %lf\n", totOrdinaires);
		fprintf(*fichier, "		cout pour les relatifs : %lf\n", totRelatives);
		fprintf(*fichier, "		cout pour les absolus : %lf\n", totAbsolus);
		fprintf(*fichier, "		cout pour les stations occupées : %lf\n", coutStationsOccupes);
		fprintf(*fichier, "		cout pour les stations libres : %lf\n", coutStationsLibres);
	}

	coutTotal = totOrdinaires + totAbsolus + totRelatives + coutStationsLibres + coutStationsOccupes;
	return coutTotal;
	
}
void calculCoutMin(double coutTotal, double *minCout, int *nbStationOptimal, int station)
{
	if (coutTotal < *minCout)
	{
		(*nbStationOptimal) = station;
		*minCout = coutTotal;
	}
}