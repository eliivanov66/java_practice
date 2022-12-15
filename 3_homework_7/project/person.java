import java.util.Date;
import java.util.Set;

/** класс описывающий персону в базе фильмов */
public class person{
    private String firstName;
    private String surName;
    private Date birthDate;
    private int age;
    private Set<film> films;
    private Set<library.jobs> job;

    // общий конструктор
    person(String argFirstName, /** имя персоны */
           String argSurName,   /** фамилия персоны */
           Date argbirthDate,   /** дата рождения */
           Set<library.jobs> argJob, /** карьера персоны */
           Set<film> argFilms) {     /** фильмы персоны */   
        this.firstName = argFirstName;
        this.surName = argSurName;
        this.birthDate = argbirthDate;
        this.job = argJob;
        this.films = argFilms;
    }

    /** метод добавляет значение в поле film */
    void addFilm(film argFilm){
        this.films.add(argFilm);
    }
    
    /** метод добавляет значение в поле job */
    void addJob(library.jobs argJob) {
        this.job.add(argJob);
    }
    
    /** метод возвращающий имя */
    String getFirstName(){
        return this.firstName;
    }
    
    /** метод возвращающий фамилию */
    String getSurName(){
        return this.surName;
    }
    
    /** метод возвращает дату рождения*/
    Date getBirthDate(){
        return this.birthDate;
    }

    /** метод возвращающий возраст*/
    int getAge(){
        return this.age;
    }

    /** метод возвращающий список фильмов */
    Set<film> getFilms(){
        return this.films;
    }

    /** метод возвращающий карьеру */
    Set<library.jobs> getJob() {
        return this.job;
    }


}
