using BeecrowdDDD;

var cityRepository = new CityRepository();

cityRepository.AppendCity(new City(61, "Brasília"));
cityRepository.AppendCity(new City(71, "Salvador"));
cityRepository.AppendCity(new City(11, "São Paulo"));
cityRepository.AppendCity(new City(21, "Rio de Janeiro"));
cityRepository.AppendCity(new City(32, "Juiz de Fora"));
cityRepository.AppendCity(new City(19, "Campinas"));
cityRepository.AppendCity(new City(27, "Vitória"));
cityRepository.AppendCity(new City(31, "Belo Horizonte"));

Console.WriteLine(cityRepository);

var userInterface = new UserInterface(cityRepository);
var userInterfaceConsole = new UserInterfaceConsole(userInterface);

while (true)
{
    var result = userInterfaceConsole.GetUserInputDDD();
    Console.WriteLine(result);
    if (result == "City not found...")
        break;
}
