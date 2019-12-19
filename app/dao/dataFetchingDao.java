
package dao;

import dto.CityHumidityDto;
import dto.CityPressureDto;
import dto.CityWindDegDto;
import io.ebean.SqlRow;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataFetchingDao {
//    public static List<SqlRow> getHumidityData() {
//        return DbConnector.createSqlQuery("SELECT HUMIDITY,city_name FROM weather_features WHERE DATE(DT_CL)='2015-01-01'").findList();
//    }

    public static CityHumidityDto getHumidityData() {
//        List<SqlRow> rows= DataFetchingDao.getHumidityData();
        List<SqlRow> rows = DbConnector.createSqlQuery("SELECT HUMIDITY,city_name FROM weather_features WHERE DATE(DT_CL)='2015-01-01'").findList();
        CityHumidityDto cityHumidityDto = new CityHumidityDto();
        for (SqlRow row : rows) {
            cityHumidityDto.setHumidityValue(row.getBigDecimal("HUMIDITY"));
            cityHumidityDto.setCityName(row.getString("city_name"));
        }
        return cityHumidityDto;

    }

    //    public static List<SqlRow> getPressureData() {
//        return DbConnector.createSqlQuery("SELECT pressure,city_name FROM weather_features WHERE DATE(DT_CL)='2015-01-01'").findList();
//    }
    public static CityPressureDto getPressureData() {
        List<SqlRow> rows = DbConnector.createSqlQuery("SELECT pressure,city_name FROM weather_features WHERE DATE(DT_CL)='2015-01-01'").findList();
        List<BigDecimal> pressureList=new ArrayList<>();
        List<String> cityList=new ArrayList<>();
        CityPressureDto cityPressureDto = new CityPressureDto();
        for (SqlRow row : rows) {
            pressureList.add(row.getBigDecimal("pressure"));
            cityList.add(row.getString("city_name"));
        }
        cityPressureDto.setPressureValues(pressureList);
        cityPressureDto.setCityNames(cityList);
        return cityPressureDto;

    }

    public static CityWindDegDto getWindDegData() {



    }
}







