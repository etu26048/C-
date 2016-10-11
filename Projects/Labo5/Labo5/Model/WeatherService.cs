using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Labo5.Model
{
    public class WeatherService
    {
        public async Task<IEnumerable<WeatherForecast>> GetForecast()
        {
            var wc = new HttpClient();
            var weather = await wc.GetStringAsync(new Uri("http://api.openweathermap.org/data/2.5/forecast?q=Namur,fr&mode=JSON&lang=fr&units=metric&APPID=cfe702ebc5bd4eb135a7110f7c02af99"));
            var rawWeather = JObject.Parse(weather);
            //Parcours le fichier JSON et en fais des objets les [] sont des balises en JSON et permettent des les identifier
            var forecast = rawWeather["list"].Children().Select(d => new WeatherForecast()
            {
                Date = d["dt_txt"].Value<DateTime>(),
                MinTemp = d["main"]["temp_min"].Value<Double>(),
                MaxTemp = d["main"]["temp_max"].Value<Double>(),
                WindSpeed = d["wind"]["speed"].Value<Double>(),
                WeatherDescription = d["weather"].First["description"].Value<string>()
    
            });
            //il le return où ce truc là ?
            return forecast;
        }
    }
}
