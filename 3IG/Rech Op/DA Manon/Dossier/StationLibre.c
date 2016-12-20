#include "Header.h"

int  gererStationLibre(int station, Station tabStations[], FileAttente *(*ptrDebOrdinaire), FileAttente *(*ptrDebAbsolu), FileAttente *(*ptrDebRelatif), int tempsService, FILE *(*fichier))
{
	if (station == SMIN && tempsService < 20) {
		fprintf(*fichier, "      stations au debut de la minute :\n");
	}
	int nbOrdTraite = 0;
	for (int iStation = 0; iStation < station; iStation++) 
	{
		if (tabStations[iStation].dureeService <= 0)
		{
			if(*ptrDebAbsolu != NULL)
			{
				tabStations[iStation].dureeService = (*ptrDebAbsolu)->dureeService;
				tabStations[iStation].priorite = 1;
				supprimerChainon(ptrDebAbsolu);
			}
			else
			{
				if(*ptrDebRelatif != NULL)
				{
					tabStations[iStation].dureeService = (*ptrDebRelatif)->dureeService;
					tabStations[iStation].priorite = 2;
					supprimerChainon(ptrDebRelatif);
				}
				else 
				{
					if (*ptrDebOrdinaire != NULL)
					{
						tabStations[iStation].dureeService = (*ptrDebOrdinaire)->dureeService;
						tabStations[iStation].priorite = 3;
						supprimerChainon(ptrDebOrdinaire);
					}
				}
			}
			
		}
		else 
		{
			if (tabStations[iStation].priorite == 3) 
			{
				nbOrdTraite++;
			}
			if (station == SMIN && tempsService < 20) {

				fprintf(*fichier, "type client = %s     duree de service restante = %d\n", (tabStations[iStation].priorite == 1) ? "Absolu" : (tabStations[iStation].priorite == 2) ? "Relatif" : "Ordinaire", tabStations[iStation].dureeService);
			}
		}
		
	}
	return nbOrdTraite;
}

void supprimerChainon(FileAttente *(*ptrDebListe)) 
{
	FileAttente* ptrTemp = *ptrDebListe;
	*ptrDebListe = (*ptrDebListe)->ptrSuiv;
	free(ptrTemp);
}