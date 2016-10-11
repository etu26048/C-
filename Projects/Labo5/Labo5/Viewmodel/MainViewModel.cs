using GalaSoft.MvvmLight;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Labo5.Model;

namespace Labo5.Viewmodel
{
    public class MainViewModel : ViewModelBase
    {


        private ObservableCollection<WeatherForecast> _forecast = null;

        public ObservableCollection<WeatherForecast> Forecast
        {
            get { return _forecast; }
            set
            { 
                if(_forecast==value)
                {
                    return;
                }
                //ici aussi svp
                _forecast = value;
                //Explication ?
                RaisePropertyChanged("Forecast");
            }
        }

        public MainViewModel()
        {
            if(IsInDesignMode)
            {
                var forecast = new Forecast() { CityName = "Namur" };
                var weatherForecasts = new List<WeatherForecast>();
                for(int i = 0;i<40;i++)
                {
                    weatherForecasts.Add(new WeatherForecast()
                    {
                        Date = DateTime.Now.AddDays(i),
                        MaxTemp = 5 + i / 2,
                        MinTemp = 0 + i / 2,
                        WeatherDescription = "Peu de nuages",
                        WindSpeed = i % 7
                    });
                }
                forecast.WeatherForecasts = weatherForecasts;
                Forecast = new ObservableCollection<WeatherForecast>(weatherForecasts);
            }
            else
            {
                InitializeAsync();
            }
        }

        private async Task InitializeAsync()
        {
            var service = new WeatherService();
            var forecast = await service.GetForecast();
            Forecast = new ObservableCollection<WeatherForecast>(forecast);
        }
    }
}
