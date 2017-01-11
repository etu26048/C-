select c.nom, c.prenom, cmd.reference as "Ref cmd", cmd.Datecommande, cmd.Montantreduction from customer c, commande cmd
where cmd.Numerocli = c.Numeroclient;

select * from ligneproduit p, commande cmd, produit pr,customer c
where p.Refproduit = pr.Reference
and cmd.Reference = p.Refcommande
and c.Numeroclient = cmd.Numerocli