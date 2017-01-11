<?php

	$nomFichier = "membres.json";
	
	
	function ajouteMembre($pseudo, $mdp, $admin){
		
		global $nomFichier;
		//il doit exister sinon -> erreur !
		$fichier = fopen($nomFichier, "r") or die("Unable to open file");
		
		if(isset($fichier)){
			
			$contenu = fread($fichier, filesize("membres.json"));
			$membres = json_decode($contenu, true);
			/*switch (json_last_error()) {
				case JSON_ERROR_NONE:
					echo ' - Aucune erreur';
				break;
				case JSON_ERROR_DEPTH:
					echo ' - Profondeur maximale atteinte';
				break;
				case JSON_ERROR_STATE_MISMATCH:
					echo ' - Inadéquation des modes ou underflow';
				break;
				case JSON_ERROR_CTRL_CHAR:
					echo ' - Erreur lors du contrôle des caractères';
				break;
				case JSON_ERROR_SYNTAX:
					echo ' - Erreur de syntaxe ; JSON malformé';
				break;
				case JSON_ERROR_UTF8:
					echo ' - Caractères UTF-8 malformés, probablement une erreur d\'encodage';
				break;
				default:
					echo ' - Erreur inconnue';
				break;
			}*/
			fclose($fichier);
			
			if(isset($membres["$pseudo"])){
				
				return false;
			}else{
				
				$fichier = fopen($nomFichier, "w");
				print_r(error_get_last());
				array_push($membres, array("pseudo" => $pseudo,array( "mdp" => $mdp, "admin" => $admin)));
				$membresJson = json_encode($membres);
				fwrite($fichier, $membresJson);
				fclose($fichier);
				return true;
			}
		}else{
			
			$membres = array();
		}
	}


?>