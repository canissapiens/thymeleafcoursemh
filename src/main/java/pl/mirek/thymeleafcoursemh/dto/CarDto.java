package pl.mirek.thymeleafcoursemh.dto;

public class CarDto {

    public int id;
    public String mark;
    public String model;

    public CarDto(int id, String mark, String model) {
        this.id = id;
        this.mark = mark;
        this.model = model;
    }
}
