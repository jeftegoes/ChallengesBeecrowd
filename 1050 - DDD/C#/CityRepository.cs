namespace BeecrowdDDD
{
    public class CityRepository
    {
        private List<City> Cities = new List<City>();

        public void AppendCity(City city)
        {
            Cities.Add(city);
        }

        public bool CheckIfCityExists(int ddd)
        {
            foreach (var city in Cities)
            {
                if (city.Ddd == ddd)
                    return true;
            }

            return false;
        }

        public City GetCity(int ddd)
        {
            foreach (var city in Cities)
            {
                if (city.Ddd == ddd)
                    return city;
            }

            return new City(-1, "Not found...");
        }

        public override string ToString()
        {
            var format = "{0}{1,20}\n";

            var menu = string.Format(format, "DDD", "Name of city");

            foreach (var city in Cities)
            {
                menu += string.Format(format, city.Ddd, city.Name);
            }

            return menu;
        }
    }
}