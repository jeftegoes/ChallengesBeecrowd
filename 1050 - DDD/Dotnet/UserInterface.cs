namespace BeecrowdDDD
{
    public class UserInterface
    {
        private readonly CityRepository _cityRepository;

        public UserInterface(CityRepository cityRepository)
        {
            _cityRepository = cityRepository;
        }

        public string GetUserInputDDD(int ddd)
        {
            if (_cityRepository.CheckIfCityExists(ddd))
                return _cityRepository.GetCity(ddd).Name;

            return "City not found...";
        }
    }
}