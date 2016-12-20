#include "Header.h"

void gererStationOccupe(int nbOrdinaireTraite, FileAttente *(*ptrDebAbsolu), FileAttente *(*ptrDebRelatif), int station, Station tabStations[])
{
	int maxTemps = 0;
	int numStation = 0;
	FileAttente *pNouvRelatif;

	while (*ptrDebAbsolu != NULL && nbOrdinaireTraite != 0)
	{
		int iStation = 0;
		while (iStation < station)
		{
			if (tabStations[iStation].priorite = 3)
			{
				if (tabStations[iStation].dureeService > maxTemps)
				{
					maxTemps = tabStations[iStation].dureeService;
					numStation = iStation;
				}
			}
			iStation++;
		}


		pNouvRelatif = (FileAttente*)malloc(sizeof(FileAttente));
		pNouvRelatif->dureeService = maxTemps;

		ajouterChainon(&pNouvRelatif, ptrDebRelatif);

		tabStations[numStation].dureeService = (*ptrDebAbsolu)->dureeService;
		tabStations[numStation].priorite = 1;

		supprimerChainon(ptrDebAbsolu);

		nbOrdinaireTraite--;

	}
}