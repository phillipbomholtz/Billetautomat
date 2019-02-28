# Billetautomat

FØR DU OVERHOVEDET TØR TÆNKE PÅ AT KØRE PROGRAMMET LÆS DET HER:
readeren for loggen crasher lige nu programmet hvis filen ikke eksistere. der er tre muligheder for at undgå dette:
1: sørg for at ved øverste lag ved dit c drev at der er en temp mappe, så laver prgrammet automatisk filen

2: i programmet kan linjen Logger log = new Logger(); ændres til at have parametre ("path", "filename")
eksempler på parametre:
path: c:/hej/med/dig/
filename: verden.txt

3: undgå readout af filen som pesten

første itteration af billetautomaten. Der er mang problemer og chancer for udvidelser 

Kendte problemer:

1: lige nu kan dato klassen brugt i main ikke give datoen men kun klokkeslettet.
2: i loggeren kan readeren crashe programmet hvis filen ikke eksistere. 
Selve filen skal man være obmærksom på eksistere. programmet burde gøre dette i constructoren for klassen,
men filen kan ikke oprettes hvis pathingen mangler mapper undervejs.


Udvidelsesideer:

1: rydde op i user interfacet så programmet kan gå i ren admin mode og bedre balance manipulation
2: flere billettyper
3: almindlig user klasse så almindelige brugere kan have global balance. dog kan stadig bruges a guest users
