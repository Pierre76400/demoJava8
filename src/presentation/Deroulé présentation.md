#P1 Log

1- Pas de trace

2- Afficher les requêtes
Passer le log "org.hibernate.SQL" au niveau DEBUG

3- Ajouter le formattage
dans le fichier "application.porperties" passer spring.jpa.properties.hibernate.format_sql à true

4- Ajouter la provenance de la requete
spring.jpa.properties.hibernate.use_sql_comments à true

5- Afficher paramétre
Passer le log "org.hibernate.type" au niveau DEBUG

#P2 Paramétres

1- Premier test (sans utiliser de paramétre)

2- Test en changeant le paramétre à "'"

3- Test plus grave avec la chaine (' or ''=')

4- Solution ajouter paramétre
		List<Classe> classes = getEntityManager()
				.createQuery("from Classe c left join fetch c.professeur where c.professeur.nom=:nomProfesseur")
				.setParameter("nomProfesseur", nomProfesseur).getResultList();
				

5 - Lancer le test paramListe

6 - Dupliquer le test paramListe

6 - Passer en paramétre la liste
createQuery("from Classe c left join fetch c.professeur where c.professeur.nom  in (:nomProfesseurs)")
				.setParameter("nomProfesseurs", nomProfesseurs).getResultList();

#P3 Chargement

1- Lancer Test 
=> Lazy exception

2- Utiliser l'option "enable_lazy_load_no_trans" (à true)

3- Désactiver l'option "enable_lazy_load_no_trans"
Passer la relation ClasseP3.eleves à EAGER

4- afficherLesClassesDUnProfesseurTest => 2 requête au lieu d'une

5 - Solution repasser la relation ClasseP3.eleves à LAZY
Utiliser Fetch "from ClasseP3 c join fetch c.eleves where c.professeur..."

6 - Présentation chargement tardif

#P4 Insert
1 - Lancement insertionDeTailleMoyenneTest
=> Temps d'insertion rapide pour 10 000

2 - Lancement insertionMassiveTest
=> Ne répond pas ? Pourquoi ? 100 000 enregistrement devrait durer dix fois plus de temps que le précédent

3 - On rajout des traces dans le précédent test tout les 10 000 enregistrements

4 - On vide la mémoire getEntityManager().clear();
=> EXPLICATION

5 - Lancer le test avec l'explication

#P5 Pb cache
1 - requeteDeleteSql
=> Ne marche pas

2 - Rajouter un raffraichissement de la session
=> getEntityManager().clear();

3 - requeteUpdateSql

4- Correction
=>Ne marche pas , un peu dommage de raffraichier toutes la session pour ça
=> getEntityManager().refresh(e);

5- requeteUpdateSql2
Quelle est le nom de l'éléve à la fin du test ?

Rajouter le nom de l'éléeve.
Rajouter les logs => Requête SQL joué aussitot
Solution faire un flush aprés le persist et ajouter un refresh

#P6 Pb Cache2
1 - Executer le tests problemePerformance 
=> La même requete est executé 2 fois , la mettre en cache

2 - Utilisation du cache manuel
=> utiliser la méthode de cache (classe = getOrPutInCache(classeRecherchee);)
=> Cela marche trés bien

3 - On doit afficher la classe et ses éléves  (afficherClasse(classe);)
=> Cela ne marche plus , pourtrant on a bien une session

4- Une solution  , réattacher l'entity à la session
classe = entityManager.merge(classe);

#P7 Cache requête
1- Execution du test => Il n'y aucun cache (4 requêtes) 

2 - On a rajouté le cache de la requête 
=> .setHint("org.hibernate.cacheable", Boolean.TRUE)
=> mais cela ne semble pas marcher
=> extrait de la définition du cache requête

3 - On rajoute  au niveau des entity Classe et au niveau Professeur , le cache :
	// @Cache(usage =CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

4 - requeteAvecCacheOneToMany
La requête fait une jointure sur la table Eleve en plus , comment faire pour la mettre en cache ?
=> On rajoute le cache sur l'entity Eleve
=> Cela ne marche toujours pas ! Pourquoi ?
=> Rajouter le cache sur la relation dans la classe "Classe"

#P8 HashCode
1- hashCodeNonRedefiniSansProbleme
On essai d'insérer une entity chargé dans !2 session / transaction différentes aucun probléme


2- On essai d'insérer des entity avec des états différents detached et menagerd => Erreur
=> On merge cela marche !


3- On essai d'insérer des entity avec des états différents new et menaged => Erreur
=> On doit redéfinir le hashcode

4- On écrit un hashcode avec l'id technique
=> Ok

5 - On lance le test résultat inattendue
=> Probléme avec les entity avec l'état NEW(Transient)

5- On écrit un hashcode avec des identifiant naturels 
