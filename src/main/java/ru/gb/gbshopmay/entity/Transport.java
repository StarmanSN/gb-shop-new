package ru.gb.gbshopmay.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gb.gbshopmay.entity.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transport extends BaseEntity {

    private String model;
    private int capacity;
    private int distance;

    public Transport() {
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDistance() {
        return distance;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Transport(Builder builder) {
        model = builder.model;
        capacity = builder.capacity;
        distance = builder.distance;
    }

    public static class Builder {

        private String model;
        private int capacity;
        private int distance;

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setDistance(int distance) {
            this.distance = distance;
            return this;
        }

        public Transport build() {
            return new Transport(this);
        }
    }

    @Override
    public String toString() {
        return "Transport{" +
                "model='" + model + '\'' +
                ", capacity=" + capacity +
                ", distance=" + distance +
                '}';
    }
}
