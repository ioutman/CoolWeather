package com.cdut.coolweather.gson;


import com.google.gson.annotations.SerializedName;

public class Forecast {
    public String date;

    @SerializedName("tmp")
    public Tempreture tempreture;

    @SerializedName("cond")
    public More more;

    public class Tempreture{
        public String max;
        public String min;
    }

    public class More{
        @SerializedName("txt_d")
        public String info;
    }
}
