#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <float.h>
#include <string.h>

#define SMIN 15
#define SMAX 30
#define TEMPS_SERVICE 960
#define X0 292
#define A 69069
#define C 0
#define M  2147483648
#define PRIORITE_ABSOLU 0.3
#define PRIORITE_RELATIF 0.4
#define MAX_ABSOLU 6
#define COUT_ABSOLU 37.5
#define COUT_RELATIF 25.5
#define COUT_ORDINAIRE 22.5
#define COUT_STATION_OCCUPE 30
#define COUT_STATION_LIBRE 18
#define MAX_ARRIVE_DUREE 57

typedef struct station Station;
struct station {
	int dureeService;
	int priorite;
};


typedef struct fileAttente {
	int dureeService;
	struct fileAttente *ptrSuiv;
}FileAttente;



int gererArrivesEtPriorite(FileAttente *(*ptrDebOrdinaire), FileAttente *(*ptrDebAbsolu), FileAttente *(*ptrDebRelatif), int xn, int tempsService, int station, FILE *(*fichier));
int genererPseudoAleatoire(int xn);
int calculDureeService(int nbPseudoAleatoire);
int calculArrive(int nbPseudoAleatoire);
FileAttente * garnirChainon(int dureeService);
void ajouterChainon(FileAttente *(*ptrChainonNouveau), FileAttente *(*ptrDebListe));
void supprimerChainon(FileAttente *(*ptrDebListe));
int  gererStationLibre(int station, Station tabStations[], FileAttente *(*ptrDebOrdinaire), FileAttente *(*ptrDebAbsolu), FileAttente *(*ptrDebRelatif), int tempsService, FILE *(*fichier));
void gererStationOccupe(int nbOrdinaireTraite, FileAttente *(*ptrDebAbsolu), FileAttente *(*ptrDebRelatif), int station, Station tabStations[]);
void calculTotaux(FileAttente *ptrDebOrdinaire, FileAttente *ptrDebAbsolu, FileAttente *ptrDebRelatif, int station, Station tabStations[], int *nbOrdinaires, int *nbRelatives, int *nbAbsolus, int *nbStationTot, int tempsService, FILE *(*fichier));
double sommeCout(int nbOrdinaires, int nbRelatives, int nbAbsolus, int nbStationsTotal, int station, FILE *(*fichier));
void calculCoutMin(double coutTotal, double *minCout, int *nbStationOptimal, int station);
void imprimerFiles(FileAttente *ptrDebAbsolu, FileAttente *ptrDebRelatif, FileAttente *ptrDebOrdinaire, FILE *(*fichier));
