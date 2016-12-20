#include "Header.h"
int gererArrivesEtPriorite(FileAttente *(*ptrDebOrdinaire), FileAttente *(*ptrDebAbsolu), FileAttente *(*ptrDebRelatif), int xn, int tempsService, int station, FILE *(*fichier))
{
	int nbPseudoAleatoire = genererPseudoAleatoire(xn);
	
	xn = nbPseudoAleatoire;
	int nbArrive = calculArrive(nbPseudoAleatoire);
	printf("nb arrives :%d\n", nbArrive);
	if (tempsService < 20 && station == SMIN) {
		fprintf(*fichier, "Nombre d'arrivées = %d\n", nbArrive);
	}

	int i = 0;
	while (i < nbArrive)
	{
		nbPseudoAleatoire = genererPseudoAleatoire(xn);
		xn = nbPseudoAleatoire;

		int dureeService = calculDureeService(xn);
		printf("duree service: %d\n", dureeService);
		

		int priorite = genererPseudoAleatoire(xn);
		xn = priorite;
		double pourcPriorite =  (double) priorite / M;
		

		nbPseudoAleatoire = genererPseudoAleatoire(xn);
		xn = nbPseudoAleatoire;
		
		//compter nb dans file absolu
		FileAttente * ptr = *ptrDebAbsolu;
		int nbAbsoluFile = 0;
		while (ptr != NULL)
		{
			nbAbsoluFile++;
			ptr = ptr->ptrSuiv;
		}
		if (pourcPriorite < PRIORITE_ABSOLU && nbAbsoluFile < MAX_ABSOLU)
		{
			printf("priorite :%d\n", 1);
			FileAttente * ptrNouv = garnirChainon(dureeService);
			ajouterChainon(&ptrNouv, ptrDebAbsolu);
		}
		else
		{
			if (pourcPriorite < PRIORITE_RELATIF)
			{
				printf("priorite :%d\n", 2);
				FileAttente * ptrNouv = garnirChainon(dureeService);
				ajouterChainon(&ptrNouv, ptrDebRelatif);
			}
			else
			{
				printf("priorite :%d\n", 3);
				FileAttente * ptrNouv = garnirChainon(dureeService);
				ajouterChainon(&ptrNouv, ptrDebOrdinaire);
			}
		}
		i++;
	}
	return xn;
}

int genererPseudoAleatoire(int xn)
{
	int x = (A*xn + C) % M;
	
	return x;
}

FileAttente * garnirChainon(int dureeService)
{
	FileAttente * ptrNouv = (FileAttente*)malloc(sizeof(FileAttente));
	ptrNouv->dureeService = dureeService;
	ptrNouv->ptrSuiv = NULL;
	return ptrNouv;
}

void ajouterChainon(FileAttente *(*ptrChainonNouveau), FileAttente *(*ptrDebListe))
{
	FileAttente * ptrNouv = *ptrDebListe;
	FileAttente * ptrPrec = NULL;
	while (ptrNouv != NULL && ptrNouv->dureeService < (*ptrChainonNouveau)->dureeService)
	{
		ptrPrec = ptrNouv;
		ptrNouv = ptrNouv->ptrSuiv;
	}
	if (ptrPrec == NULL) {
		(*ptrChainonNouveau)->ptrSuiv = *ptrDebListe;
		*ptrDebListe = *ptrChainonNouveau;
	}
	else {
		ptrPrec->ptrSuiv = (*ptrChainonNouveau);
		(*ptrChainonNouveau)->ptrSuiv = ptrNouv;
	}
}

int calculArrive(int nbPseudoAleatoire)
{
	double pourcDuree = (double) nbPseudoAleatoire / M;
	
	if (pourcDuree < 0.09)
	{
		return 0;
	}
	else
		if (pourcDuree < 0.12)
		{
			return 1;
		}
		else
			if (pourcDuree < 0.18)
			{
				return 2;
			}
			else
			{
				if (pourcDuree < 0.66)
				{
					return 3;
				}
				else
				{
					if (pourcDuree < 0.88)
					{
						return 4;
					}
					else
					{
						return 5;
					}
				}
			}
}

int calculDureeService(int nbPseudoAleatoire) {

	double pourcArrive = (double) nbPseudoAleatoire / M;

	if (pourcArrive < 0.04)
	{
		return 1;
	}
	else
	{
		if (pourcArrive < 0.09)
		{
			return 2;
		}
		else
		{
			if (pourcArrive < 0.12)
			{
				return 3;
			}
			else
			{
				if (pourcArrive < 0.32)
				{
					return 4;
				}
				else
				{
					if (pourcArrive < 0.61)
					{
						return 5;
					}
					else
					{
						return 6;
					}
				}
			}
		}
	}
}

void imprimerFiles(FileAttente *ptrDebAbsolu, FileAttente *ptrDebRelatif, FileAttente *ptrDebOrdinaire, FILE *(*fichier)) {
	if(ptrDebAbsolu != NULL || ptrDebOrdinaire != NULL || ptrDebRelatif != NULL)
		fprintf(*fichier, "      files d'attente en debut de minute : \n");
	FileAttente *ptr;
	ptr = ptrDebAbsolu;
	while (ptr != NULL) {
		fprintf(*fichier, "type client = Absolu    duree de service restante = %d\n", ptr->dureeService);
		ptr = ptr->ptrSuiv;
	}
	ptr = ptrDebRelatif;
	while (ptr != NULL) {
		fprintf(*fichier, "type client = Relatif    duree de service restante = %d\n", ptr->dureeService);
		ptr = ptr->ptrSuiv;
	}
	ptr = ptrDebOrdinaire;
	while (ptr != NULL) {
		fprintf(*fichier, "type client = Ordinaire    duree de service restante = %d\n", ptr->dureeService);
		ptr = ptr->ptrSuiv;
	}
}