import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;


public class filmsBD {

    public HashSet<film> films = new HashSet<>();
    public HashSet<person> persones = new HashSet<>();
    
    public filmsBD() {
        Random rand = new Random();
        
        int dbFilmsSize = rand.nextInt(0, 200);
        int dbPersonesSize = rand.nextInt(0, 10000);
        
        //заполнение базы персон
        for (int index = 0; index <= dbPersonesSize; index++) {
            String tempFirstName = library.firstNameVariants[rand.nextInt(library.firstNameVariants.length)];
            String tempSurName = library.surNameVariants[rand.nextInt(library.surNameVariants.length)];
            Date tempBirthDate = new Date();
            tempBirthDate = new Date(rand.nextLong(tempBirthDate.getTime()));
            
            HashSet<library.jobs> tempJob = new HashSet<>();
            tempJob.add(library.jobs.values()[rand.nextInt(library.jobs.values().length)]);
            HashSet<film> tempFilms = new HashSet<>();
            person tempPerson = new person(tempFirstName, tempSurName, tempBirthDate, tempJob, tempFilms);
            this.persones.add(tempPerson);
        }
        //заполнение базы фильмов
        for (int index = 0; index <= dbFilmsSize; index++) {
            String tempName = library.name1Variants[rand.nextInt(library.name1Variants.length)] + " " +
                              library.name2Variants[rand.nextInt(library.name2Variants.length)];
            
            library.genre tempGenre = library.genre.values()[rand.nextInt(library.genre.values().length)];
            
            int tempYear = rand.nextInt(1950, 2022);
            
            String tempCountry = library.countryVariants[rand.nextInt(library.countryVariants.length)];
            HashSet<String> tempCountrys = new HashSet<>();
            tempCountrys.add(tempCountry);

            int tempFilmLenght = rand.nextInt(15, 180);

            
            person tempPerson;
            int tempCount;
            HashSet<person> tempDirectors = new HashSet<>();
            tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
            tempCount = rand.nextInt(1,3);
            for (int i = 0; i <= tempCount; i++) {
                do {
                    tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
                } while (! tempPerson.getJob().contains(library.jobs.director));
                tempDirectors.add(tempPerson);
            }

            HashSet<person> tempProducers = new HashSet<>();
            tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
            tempCount = rand.nextInt(1,3);
            for (int i = 0; i <= tempCount; i++) {
                do {
                    tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
                } while (! tempPerson.getJob().contains(library.jobs.producer));
                tempProducers.add(tempPerson);
            }

            HashSet<person> tempComposers = new HashSet<>();
            tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
            tempCount = rand.nextInt(1,3);
            for (int i = 0; i <= tempCount; i++) {
                do {
                    tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
                } while (! tempPerson.getJob().contains(library.jobs.composer));
                tempComposers.add(tempPerson);
            }

            HashSet<person> tempOperators = new HashSet<>();
            tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
            tempCount = rand.nextInt(1,3);
            for (int i = 0; i <= tempCount; i++) {
                do {
                    tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
                } while (! tempPerson.getJob().contains(library.jobs.operator));
                tempOperators.add(tempPerson);
            }

            HashSet<person> tempScreenWriters = new HashSet<>();
            tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
            tempCount = rand.nextInt(1,3);
            for (int i = 0; i <= tempCount; i++) {
                do {
                    tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
                } while (! tempPerson.getJob().contains(library.jobs.screenwriter));
                tempScreenWriters.add(tempPerson);
            }

            HashSet<Entry<String, person>> tempActors = new HashSet<>();
            tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
            tempCount = rand.nextInt(1,10);
            String tempRole = "";
            for (int i = 0; i <= tempCount; i++) {
                do {
                    tempPerson = (person) persones.toArray()[rand.nextInt(persones.toArray().length)];
                    tempRole = library.roleVariants[rand.nextInt(library.roleVariants.length)];
                } while (! tempPerson.getJob().contains(library.jobs.actor));
                Entry<String,person> tempEntry = Map.entry(tempRole, tempPerson);
                tempActors.add(tempEntry);
            }

            film tempFilm = new film(tempName,
                                     tempGenre.toString(), 
                                     tempYear, 
                                     tempCountrys, 
                                     tempFilmLenght, 
                                     tempDirectors, 
                                     tempProducers, 
                                     tempComposers, 
                                     tempOperators, 
                                     tempScreenWriters, 
                                     tempActors);
            this.films.add(tempFilm);
            for (person element : tempDirectors) {
                element.addFilm(tempFilm);
            }
            for (person element : tempProducers) {
                element.addFilm(tempFilm);
            }
            for (person element : tempComposers) {
                element.addFilm(tempFilm);
            }
            for (person element : tempOperators) {
                element.addFilm(tempFilm);
            }
            for (person element : tempScreenWriters) {
                element.addFilm(tempFilm);
            }
            for (Entry<String, person> element : tempActors) {
                element.getValue().addFilm(tempFilm);
            }
        }
    }

    
}
