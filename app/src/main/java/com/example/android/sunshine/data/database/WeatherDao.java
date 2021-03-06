package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;

@Dao
public interface WeatherDao {

    /**
     * Insert a list of {@link WeatherEntry} into the weather table. If there's a conflicting id
     * or date the weather entry uses the {@link OnConflictStrategy} of replacing the weather
     * forecast. Ther required uniqueness of these values is defined in the {@link WeatherEntry}
     *
     * @param weather A list of weather forecasts to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weather);

    /**
     * Gets the weather for a single day
     *
     * @param date The date you want weather for
     * @return Weather for a single day
     */
    @Query("SELECT * FROM weather WHERE date = :date")
    WeatherEntry getWeatherByDate(Date date);
}
