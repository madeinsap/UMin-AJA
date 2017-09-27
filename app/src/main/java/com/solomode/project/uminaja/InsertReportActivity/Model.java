package com.solomode.project.uminaja.InsertReportActivity;

/**
 * Created by madeinsap on 9/25/2017.
 */

public class Model {
    private int id;
    private String tittle, subtittle;

    public Model(int id, String tittle, String subtittle) {
        this.id = id;
        this.tittle = tittle;
        this.subtittle = subtittle;
    }

    public int getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getSubtittle() {
        return subtittle;
    }
}
