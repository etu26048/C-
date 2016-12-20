#include "Header.h"

void main(void)
{
	//init
	double coutMin = DBL_MAX;
	int s = SMIN;
	int nbStationOptimal = SMIN;
	Station tabStations[SMAX];
	FILE * fichier1;
	FILE * fichier2;
	fopen_s(&fichier1, "sortie20premiereminutes.txt", "w");
	fopen_s(&fichier2, "coutTotaux.txt", "w");
	//boucle
	while (s < SMAX) {
		fprintf(fichier2, "nombre de station = %d\n", s);
		//initStation
		FileAttente* ptrDebOrdinaire = NULL;
		FileAttente* ptrDebAbsolu = NULL;
		FileAttente* ptrDebRelatif = NULL;
		int t = 0;
		int xn = 0;

		xn = X0;
		printf("%d\n", xn);
		//init tabStation
		for (int i = 0; i < s; i++) {
			tabStations[i].dureeService = 0;
			tabStations[i].priorite = 0;
		}
		int nbAbsoluTot = 0;
		int nbRelatifTot = 0;
		int nbOrdinaireTot = 0;
		int nbStationTot = 0;
		double coutTot = 0;
		
		//boucle
		while (t < TEMPS_SERVICE) {
			printf("******nouvelle minute ******");
			if (t < 20 && s == SMIN) {
				fprintf(fichier1, "temps de service = %d\n", t);
			}
			int nbOrdTraite;
			int xn1 = xn;
			xn = gererArrivesEtPriorite(&ptrDebOrdinaire, &ptrDebAbsolu, &ptrDebRelatif, xn1, t, s, &fichier1);
			if (t < 20 && s == SMIN) {
				imprimerFiles(ptrDebAbsolu, ptrDebRelatif, ptrDebOrdinaire, &fichier1);
			}
			nbOrdTraite = gererStationLibre(s, tabStations,&ptrDebOrdinaire, &ptrDebAbsolu, &ptrDebRelatif, t, &fichier1);
			gererStationOccupe(nbOrdTraite, &ptrDebAbsolu, &ptrDebRelatif, s, tabStations);
			calculTotaux(ptrDebOrdinaire, ptrDebAbsolu, ptrDebRelatif, s, tabStations, &nbOrdinaireTot, &nbRelatifTot, &nbAbsoluTot, &nbStationTot, t, &fichier1);
			t++;
			if (t < 20 && s == SMIN) {
				fprintf(fichier1, "------------------------------------------------------------------------------\n");
			}
			
		}
		
		coutTot = sommeCout(nbOrdinaireTot, nbRelatifTot, nbAbsoluTot, nbStationTot, s, &fichier2);
		printf("%lf\n",coutTot);
		system("pause");
		calculCoutMin(coutTot, &coutMin, &nbStationOptimal, s);
		fprintf(fichier2, "  cout total = %lf\n", coutTot);
		
		s++;
		
	}
	printf("%d\n", nbStationOptimal);
	fclose(fichier2);
	fclose(fichier1);
	system("pause");
	//sortie(fichier)
}