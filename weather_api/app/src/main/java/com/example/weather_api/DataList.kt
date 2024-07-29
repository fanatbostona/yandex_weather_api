package com.example.weather_api

data class DataList(
    val now: Int,
    val now_dt: String,
    val info: InfoList,
    val fact: FactList,
    val forecast: ForecastList
)

data class InfoList(
    val url: String, // ссылка
    val lat: Double, // долгота
    val lon: Double // широта
)

data class FactList(
    val obs_time: Int, // абсолютное время
    val temp: Int, // температура сейчас
    val feels_like: Int, // ощущается как
    val icon: String, // иконка общих погодный условий
    val condition: String, // общие погодные условия
    val wind_speed: Double, // скорость ветра
    val wind_dir: String, // направление ветра
    val pressure_mm: Int, // давление в мм ртутного столба
    val pressure_pa: Int, // давление в паскалях
    val humidity: Int, // содержание газообразной воды в воздухе
    val daytime: String, // утро, день, вечер, ночь
    val polar: Boolean, // полярный ли день
    val season: String, // сезон
    val wind_gust: Double // скорость порывов ветра
)

data class ForecastList(
    val date: String, // дата
    val date_ts: Int, // абсолютная дата
    val week: Int, // неделя
    val sunrise: String, // восход
    val sunset: String, // закат
    val moon_code: Int, // код луны
    val moon_text: String, // текст
    val parts: List<PartList> // остальные параметры (передаются листом)
)

data class PartList(
    val part_name: String,
    val temp_min: Int, // минимальная температура
    val temp_avg: Int, // средняя температура
    val temp_max: Int, // максимальная температура
    val wind_speed: Double, // скорость ветра
    val wind_gust: Double, // порывы ветра
    val wind_dir: String, // направление ветра
    val pressure_mm: Int, // давление в мм
    val pressure_pa: Int, // давление в па
    val humidity: Int, // влажность
    val prec_mm: Double,
    val prec_prob: Int,
    val prec_period: Int,
    val icon: String, // иконка погоды
    val condition: String, // общие погодные условия
    val feels_like: Int, // ощущается как
    val daytime: String, // время суток
    val polar: Boolean // полярный ли день
)
