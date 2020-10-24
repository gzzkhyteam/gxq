package com.hengyunsoft.validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;

public class Car {

    @NotNull(groups= {MustNoneNull.class},message="this is pdy")
    private String manufacturer;

    @NotNull(groups= {MustNoneNull.class})
    @Size(min = 2, max = 14)
    private String licensePlate;

    @Min(2)
    private int seatCount;

    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }

    //getters and setters ...
}