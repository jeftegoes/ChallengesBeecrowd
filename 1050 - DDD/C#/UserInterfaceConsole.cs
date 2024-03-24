namespace BeecrowdDDD
{
    public class UserInterfaceConsole
    {
        private readonly UserInterface _userInterface;

        public UserInterfaceConsole(UserInterface userInterface)
        {
            _userInterface = userInterface;
        }

        public string GetUserInputDDD()
        {
            Console.WriteLine("Inform code of DDD to search destination: ");
            var ddd = int.Parse(Console.ReadLine() ?? "");
            return _userInterface.GetUserInputDDD(ddd);
        }
    }
}