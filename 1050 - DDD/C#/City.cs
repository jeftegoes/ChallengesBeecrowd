namespace BeecrowdDDD
{
    public class City
    {
        public int Ddd { get; set; }
        public string Name { get; set; } = string.Empty;

        public City(int ddd, string name)
        {
            this.Ddd = ddd;
            this.Name = name;
        }
    }
}