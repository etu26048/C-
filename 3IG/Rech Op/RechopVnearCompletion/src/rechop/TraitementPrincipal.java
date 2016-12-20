/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rechop;
import Model.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author dark-
 */
public class TraitementPrincipal {
    private int sMin, sMax, s = sMin, nbStationOptimal;
    private double tempsSimulation;
    private ArrayList<Absolu> fileAbsolu;
    private ArrayList<Ordinaire> fileOrdinaire;
    private ArrayList<Relatif> fileRelatif;
    private ArrayList<Station> stations;
    private int t = 0;
    private int tempsInoccupation;
    private int tempsOccupation;
    private int tempsPrioritéAbsolue;
    private int tempsPrioritéRelative;
    private int tempsPrioritéOrdinaire;
    private int totalArrivées;
    private int xn;
    private int xn1;
    private PrintWriter sortieDeuxième = null;
    private PrintWriter sortiePremière = null;
    private int totalDs = 0;
    
    public TraitementPrincipal(int sMin, int sMax, double tempsSimulation, int nbStationOptimal){
        this.sMin = sMin;
        this.sMax = sMax;
        this.tempsSimulation = tempsSimulation;
    }
    
    public void simulation(){
        try{
            sortiePremière = new PrintWriter(new FileWriter("FichierPremièreSortie.txt"),false);
            sortieDeuxième = new PrintWriter(new FileWriter("FichierDernièreSortie.txt"),false);
            s = sMin;
            initGen();
            while(s <= sMax){
                t = 0;
                tempsInoccupation = 0;
                tempsOccupation = 0;
                tempsPrioritéAbsolue = 0;
                tempsPrioritéRelative = 0;
                tempsPrioritéOrdinaire = 0;
                totalArrivées = 0;
                xn = Constante.X;
                while(t < tempsSimulation){
                    xn1 = xn;
                    sortieDeuxième.println("Temps de simulation : "+t+" min");

                    xn = traitement(xn1);
                    if(t == 19){
                        sortiePremière.println("Coûts pour les 20 premières minutes");
                        sortiePremière();
                        sortiePremière.close();
                    }
                    sortieDeuxième.println("---------------------------------");
                    t++;
                }
                s++;
               // sortieDeuxième.close();
        }
        sortieDeuxième();
        sortieDeuxième.close();
        
        
    }catch(IOException e){
            System.out.println(e.getMessage());
    }finally{
            if(sortieDeuxième != null){
                try{sortieDeuxième.close();}
                catch(Exception e){}
            }
            
            if(sortiePremière != null){
                try{sortiePremière.close();}
                catch(Exception e){}
            }
        }
        
    }
    
 
    public void initGen(){
        stations = new ArrayList<>();
        for(int i = 0;i < s;i++){
            stations.add(new Station(0, ' '));
        }
        fileAbsolu = new ArrayList<>();
        fileOrdinaire = new ArrayList<>();
        fileRelatif = new ArrayList<>();
    }

    public int calculArrivée(int nb){
        double pourcDuree = (double) nb / 2147483647;
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
    
    public int calculDureeService(int nbPseudoAleatoire) {

	double pourcArrive = (double) nbPseudoAleatoire / 2147483647;

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
    
    public int traitement(int xn){
        int nbAléatoire = générationNombre(xn);
        xn = nbAléatoire;
        int nbArrivées = calculArrivée(nbAléatoire);
        sortieDeuxième.println("Nombre d'arrivées : "+nbArrivées);
        totalArrivées += nbArrivées;
        int cpt = 0;
        int priorité;
        int duréeService;
        while(cpt < nbArrivées){
            nbAléatoire = générationNombre(xn);
            xn = nbAléatoire;
            duréeService = calculDureeService(xn);
            totalDs += duréeService;
            sortieDeuxième.println("\tDurée de service : "+duréeService);
            priorité = générationNombre(xn);
            xn = priorité;
            double pourcPrio = (double) priorité / 2147483647;
            System.out.println(pourcPrio);
            nbAléatoire = générationNombre(xn);
            xn = nbAléatoire;
            
            if(pourcPrio < 0.3){
                if(fileAbsolu.size() < 5){
                    fileAbsolu.add(new Absolu(duréeService,'A'));
                }else{
                    fileRelatif.add(new Relatif(duréeService,'R'));
                }
            }else{
                if(pourcPrio < 0.4){
                    fileRelatif.add(new Relatif(duréeService, 'R'));               
                }else{
                    fileOrdinaire.add(new Ordinaire(duréeService, 'O'));                  
                }
            }
            cpt++;
        }
        
        if(nbArrivées != 0){
            trierFileDecroissant();
            
            sortieDeuxième.println("\tContenu de la file absolue pour la minute");
            for(Absolu absolu : fileAbsolu){
                sortieDeuxième.println("\t\t"+absolu);
            }
            sortieDeuxième.println("\tContenu de la file relative pour la minute");
            for(Relatif relatif : fileRelatif){
                sortieDeuxième.println("\t\t"+relatif);
            }
            sortieDeuxième.println("\tContenu de la file ordinaire pour la minute");
            for(Ordinaire ordinaire : fileOrdinaire){
                sortieDeuxième.println("\t\t"+ordinaire);
            }
            //les files sont triées par DS
            //Gestion des stations libre
            //on ajoute de nouvelles stations alors qu'on a déjà fait tout d'un coup dans init gen not possible
            Station station;
            for(int iStation = 0; (iStation < s); iStation++){
                if(stations.get(iStation).getDs() == 0)
                {
                    if(!fileAbsolu.isEmpty()){
                        stations.get(iStation).setDs(fileAbsolu.get(0).getDs());
                        stations.get(iStation).setPriorité(fileAbsolu.get(0).getPriorité());
                        sortieDeuxième.println("Station en début de minute : /numéro de station "+iStation);
                        sortieDeuxième.println("\t"+stations.get(iStation).toString());
                        if(fileAbsolu.size() == 1)
                           fileAbsolu = new ArrayList<>();
                        else
                        {
                            fileAbsolu.remove(0);
                        }
                    }else{
                        if(!fileRelatif.isEmpty()){
                            stations.get(iStation).setDs(fileRelatif.get(0).getDs());
                            stations.get(iStation).setPriorité(fileRelatif.get(0).getPriorité());
                            sortieDeuxième.println("Station en début de minute : /numéro de station "+iStation);
                            sortieDeuxième.println("\t"+stations.get(iStation).toString());
                            if(fileRelatif.size() == 1)
                                fileRelatif = new ArrayList<>();
                            else
                                fileRelatif.remove(0);
                        }else{
                            if(!fileOrdinaire.isEmpty()){
                                stations.get(iStation).setDs(fileOrdinaire.get(0).getDs());
                                stations.get(iStation).setPriorité(fileOrdinaire.get(0).getPriorité());
                                sortieDeuxième.println("Station en début de minute : /numéro de station "+iStation);
                                sortieDeuxième.println("\t"+stations.get(iStation).toString());
                                if(fileOrdinaire.size() == 1)
                                    fileOrdinaire = new ArrayList<>();
                                else
                                    fileOrdinaire.remove(0);
                            }
                        }
                    }
                }
            }

            //Gestion des stations occupées
            int maxDS = 0;
            int indice = 0;
            int iStation;
            for(iStation = 0; iStation < s && fileAbsolu.size() > 0; iStation++){
                maxDS = -2147483648;
                for(int j = 0; j < s; j++){
                    if(maxDS < stations.get(j).getDs() && stations.get(j).getPriorité() == 'O'){
                        maxDS = stations.get(j).getDs();
                        indice = j;
                    }
                }
            }

            if(maxDS != -2147483648 && fileAbsolu.size() > 0){
                //A revérifier !!!
                Relatif rel = new Relatif(stations.get(indice).getDs(), 'R');
                fileRelatif.add(0, rel);
                stations.get(indice).setDs(fileAbsolu.get(0).getDs());
                stations.get(indice).setPriorité(fileAbsolu.get(0).getPriorité());
                fileAbsolu.remove(0);
            }
        }
        coutProgressif();
        sortieDeuxième.println("Station en fin de minute : ");
        for(Station station : stations){
            if(station.getDs() != 0){
                sortieDeuxième.println("\t"+station.toString());
            }
        }
        return xn;
    }
    
    public void sortiePremière(){
        sortiePremière.println("Total des arrivées: " + totalArrivées);
        sortiePremière.println("Total prix du temps d'inoccupation total: " + tempsInoccupation * (Constante.COUT_HEURE_INOCCUPATION_STATION/60));
        sortiePremière.println("Total prix du temps d'occupation total: " + tempsOccupation * (Constante.COUT_HEURE_OCCUPATION_STATION/60));
        sortiePremière.println("Total du nombre de priorités absolues: " + tempsPrioritéAbsolue * (Constante.COUT_HEURE_ABSOLU/60));
        sortiePremière.println("Total du nombre de priorités relatives:  " + tempsPrioritéRelative * (Constante.COUT_HEURE_RELATIF/60));
        sortiePremière.println("Total du nombre de priorités Ordinaires: " + tempsPrioritéOrdinaire * (Constante.COUT_HEURE_ORDINAIRE/60));
    }
    
    public void sortieDeuxième(){
        double lambda = totalArrivées/tempsSimulation;
        double mu = totalDs;
        double psi;
        sortieDeuxième.println("Total des arrivées: " + totalArrivées);
        sortieDeuxième.println("Total prix du temps d'inoccupation total: " + tempsInoccupation * (Constante.COUT_HEURE_INOCCUPATION_STATION/60));
        sortieDeuxième.println("Total prix du temps d'occupation total: " + tempsOccupation * (Constante.COUT_HEURE_OCCUPATION_STATION/60));
        sortieDeuxième.println("Total prix des priorités absolues: " + tempsPrioritéAbsolue * (Constante.COUT_HEURE_ABSOLU/60));
        sortieDeuxième.println("Total prix des priorités relatives:  " + tempsPrioritéRelative * (Constante.COUT_HEURE_RELATIF/60));
        sortieDeuxième.println("Total prix des priorités Ordinaires: " + tempsPrioritéOrdinaire * (Constante.COUT_HEURE_ORDINAIRE/60));
    }
    
    public int générationNombre(int xn){
        int tmp =  (Constante.A*xn+Constante.C) % 2147483647;
        return tmp;
    }
    
    public void trierFileDecroissant(){
        Collections.sort(fileAbsolu,new Comparator<Absolu>(){
            @Override
            public int compare(Absolu t, Absolu t1) {
                return t1.getDs().compareTo(t.getDs());
            }            
        });
        
        Collections.sort(fileRelatif,new Comparator<Relatif>(){
            @Override
            public int compare(Relatif t, Relatif t1) {
                return t1.getDs().compareTo(t.getDs());
            }            
        });
        
        Collections.sort(fileOrdinaire,new Comparator<Ordinaire>(){
            @Override
            public int compare(Ordinaire t, Ordinaire t1) {
                return t1.getDs().compareTo(t.getDs());
            }            
        });
    }
    
    public void coutProgressif(){
        for(int i = 0; i < s; i++){
            if(stations.get(i).getDs() == 0)
                tempsInoccupation++;
            else{
                tempsOccupation++;
                if(stations.get(i).getPriorité() == 'A')
                    tempsPrioritéAbsolue++;
                else{
                   if(stations.get(i).getPriorité() == 'R')
                       tempsPrioritéRelative++;
                   else
                       tempsPrioritéOrdinaire++;
                }
            }
            
            if(stations.get(i).getDs() > 0){
                int ds = stations.get(i).getDs();
                ds-=1;
                stations.get(i).setDs(ds);
            }
           
        }
    }
    
    
    
    
    
    public Integer getsMin() {
        return sMin;
    }

    public void setsMin(Integer sMin) {
        this.sMin = sMin;
    }

    public Integer getsMax() {
        return sMax;
    }

    public void setsMax(Integer sMax) {
        this.sMax = sMax;
    }

    public Integer getS() {
        return s;
    }

    public void setS(Integer s) {
        this.s = s;
    }

    public Integer getNbStationOptimal() {
        return nbStationOptimal;
    }

    public void setNbStationOptimal(Integer nbStationOptimal) {
        this.nbStationOptimal = nbStationOptimal;
    }

    public Double getTempsSimulation() {
        return tempsSimulation;
    }

    public void setTempsSimulation(Double tempsSimulation) {
        this.tempsSimulation = tempsSimulation;
    }
}