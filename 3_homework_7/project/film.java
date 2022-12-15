import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

/** класс описывающий фильм в базе фильмов */
public class film {
    private String name;
    private String genre;
    private Integer year;
    private HashSet<String> country;
    private Integer filmLenght;
    private HashSet<person> directors;
    private HashSet<person> producers;
    private HashSet<person> composers;
    private HashSet<person> operators;
    private HashSet<person> screenwriters;
    private HashSet<Entry<String, person>> actors;
    
    //общий конструктор
    film(
        String argName,
        String argGenre,
        Integer argYear,
        HashSet<String> argCountry,
        Integer argFilmLenght,
        HashSet<person> argDirectors,
        HashSet<person> argProducers,
        HashSet<person> argComposers,
        HashSet<person> argOperators,
        HashSet <person> argScreenwriters,
        HashSet<Entry<String, person>> argActor){

        this.name = argName;
        this.genre = argGenre;
        this.year = argYear;
        this.country = argCountry;
        this.filmLenght = argFilmLenght;
        this.directors = argDirectors;
        this.producers = argProducers;
        this.composers = argComposers;
        this.operators = argOperators;
        this.screenwriters = argScreenwriters;
        this.actors = argActor;
    }

    /** метод возвращающий имя фильма */
    String getArgName(){
        return this.name;
    }

    /** метод возвращающий жанр фильма */
    String getGenre(){
            return this.genre;
    }
    /** метод возвращающий год выпуска фильма */
    Integer getYear(){
        return this.year;
    }
    /** метод возвращающий страну производства фильма */
    HashSet<String> getCountry(){
        return this.country;
    }
    /** метод возвращающий длительность фильма */
    Integer getFilmLenght(){
        return this.filmLenght;
    }
    /** метод возвращающий режиссёров фильма */
    HashSet<person> getDirectors(){
        return this.directors;
    }
    /** метод возвращающий продюссеров фильма */
    HashSet<person> getProducers(){
        return this.producers;
    }
    /** метод возвращающий композиторов фильма */
    HashSet<person> getComposers(){
        return this.composers;
    }
    /** метод возвращающий операторов фильма */
    HashSet<person> getOperators(){
        return this.operators;
    }
    /** метод возвращающий сценаристов фильма */
    HashSet<person> getScreenwriters(){
        return this.screenwriters;
    }
    /** метод возвращающий актёров */
    HashSet<Entry<String, person>> getActors(){
        return this.actors;
    }
    /** метод добавляющий страну производства */
    void addCountry(String arg){
        this.country.add(arg);
    }

    void addPerson(library.jobs argJob, person argPerson, String role){
        switch (argJob) {
            case director:
                this.directors.add(argPerson);
                break;
            case producer:
                this.producers.add(argPerson);
                break;
            case composer:
                this.composers.add(argPerson);
                break;
            case operator:
                this.operators.add(argPerson);
                break;
            case screenwriter:
                this.screenwriters.add(argPerson);
                break;
            case actor: 
                Entry<String, person> temp = Map.entry(role, argPerson);
                this.actors.add(temp);
                break;
        }
    }

    String Getinfo(){
        StringBuilder temp = new StringBuilder();
        temp.append("===================******======================\n");
        temp.append(String.format("Название фильма: %s\n", this.name));
        temp.append(String.format("Название жанр: %s\n", this.genre));
        temp.append(String.format("Год выпуска: %d\n", this.year));
        
        temp.append(String.format("Страна: "));
        for (String element : this.country) {
            temp.append(String.format("%s, ", element));
        }
        temp.append("\n");
        
        temp.append(String.format("Продолжительность: %d мин\n", this.filmLenght));
        
        temp.append(String.format("Режиссёр : "));
        for (person element : this.directors) {
            temp.append(String.format("%s ", element.getSurName()));
            temp.append(String.format("%s, ", element.getFirstName()));
        }
        temp.deleteCharAt(temp.length() -  1);
        temp.deleteCharAt(temp.length() -  1);
        temp.append("\n");

        temp.append(String.format("Продюссер: "));
        for (person element : this.producers) {
            temp.append(String.format("%s ", element.getSurName()));
            temp.append(String.format("%s, ", element.getFirstName()));
        }
        temp.deleteCharAt(temp.length() -  1);
        temp.deleteCharAt(temp.length() -  1);
        temp.append("\n");

        temp.append(String.format("Композитор: "));
        for (person element : this.composers) {
            temp.append(String.format("%s ", element.getSurName()));
            temp.append(String.format("%s, ", element.getFirstName()));
        }
        temp.deleteCharAt(temp.length() -  1);
        temp.deleteCharAt(temp.length() -  1);
        temp.append("\n");

        temp.append(String.format("Сценарист: "));
        for (person element : this.screenwriters) {
            temp.append(String.format("%s ", element.getSurName()));
            temp.append(String.format("%s, ", element.getFirstName()));
        }
        temp.deleteCharAt(temp.length() -  1);
        temp.deleteCharAt(temp.length() -  1);
        temp.append("\n");

        temp.append(String.format("Оператор: "));
        for (person element : this.operators) {
            temp.append(String.format("%s ", element.getSurName()));
            temp.append(String.format("%s, ", element.getFirstName()));
        }
        temp.deleteCharAt(temp.length() -  1);
        temp.deleteCharAt(temp.length() -  1);
        temp.append("\n");

        temp.append(String.format("В ролях: \n"));
        for (Entry<String, person> element : this.actors) {
            temp.append(String.format(" в роли %s - ", element.getKey()));
            temp.append(String.format("%s ", element.getValue().getSurName()));
            temp.append(String.format("%s\n", element.getValue().getFirstName()));
        }
        temp.append("===============================================\n");
        return temp.toString();
    }

}

