package com.example.tomcattest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "generactive")
public class Generactive extends Item {

    @Column(name = "complexity")
    private int complexity;

    public Generactive() {
        super();
        complexity = 0;
    }

    public Generactive(int complexity) {
        this.complexity = complexity;
    }

    public Generactive(long id, int basePrice, String name) {
        super(basePrice, name);
    }

    public Generactive(int basePrice, String name, String currency, int complexity) {
        super(basePrice, name, currency);
        this.complexity = complexity;
    }

    public Generactive(int basePrice, String name, String imageUrl, int complexity, String currency) {
        super(basePrice, name, imageUrl, currency);
        this.complexity = complexity;
    }

    public Generactive(int basePrice, String name, String imageUrl, String currency, Group parentGroup, int complexity) {
        super(basePrice, name, imageUrl, currency, parentGroup);
        this.complexity = complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    @Override
    public int calculatePrice(Configuration configuration) {
        switch (configuration.getResolution()) {
            case HD:
                return this.getBasePrice() * complexity;
            case FHD:
                return this.getBasePrice() * 2 * complexity;
            case _4K:
                return this.getBasePrice() * 4 * complexity;
        }
        return 0;
    }

    public int getComplexity() {
        return complexity;
    }

}
