/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  17/03/2016 16:04:57                      */
/*==============================================================*/


drop table if exists Droit;

drop table if exists Personne;

drop table if exists Profil;

drop table if exists Utilisateur;

/*==============================================================*/
/* Table : Droit                                                */
/*==============================================================*/
create table Droit
(
   id                   int not null auto_increment,
   Pro_id               int,
   libelle              varchar(254),
   menu                 varchar(254),
   actif                bool,
   primary key (id)
);

/*==============================================================*/
/* Table : Personne                                             */
/*==============================================================*/
create table Personne
(
   id                   int not null auto_increment,
   nom                  varchar(254),
   prenom               varchar(254),
   mail                 int,
   photo                tinyint,
   dateNaissance        datetime,
   primary key (id)
);

/*==============================================================*/
/* Table : Profil                                               */
/*==============================================================*/
create table Profil
(
   id                   int not null auto_increment,
   libelle              varchar(254),
   actif                bool,
   primary key (id)
);

/*==============================================================*/
/* Table : Utilisateur                                          */
/*==============================================================*/
create table Utilisateur
(
   id                   int not null,
   Pro_id               int,
   nomUtilisateur       varchar(254),
   motPasse             varchar(254),
   cle                  int,
   primary key (id)
);

alter table Droit add constraint FK_possede foreign key (Pro_id)
      references Profil (id) on delete restrict on update restrict;

alter table Utilisateur add constraint FK_Generalisation_3 foreign key (id)
      references Personne (id) on delete restrict on update restrict;

alter table Utilisateur add constraint FK_avoir foreign key (Pro_id)
      references Profil (id) on delete restrict on update restrict;

