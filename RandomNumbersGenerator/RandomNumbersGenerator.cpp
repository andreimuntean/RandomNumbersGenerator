#include <iostream>
#include <random>
#include <vector>

using namespace std;

bool hasSeed;
long seed;

/**
 * Generates a list of random integers.
 *
 * @param smallest The smallest integer that can appear in the list. Inclusive.
 * @param highest The highest integer that can appear in the list. Inclusive.
 * @param count The number of integers in the list.
 *
 * @return A list of random integers.
 */
vector<int> generate(int smallest, int highest, int count)
{
    vector<int> randomNumbers;
    mt19937 random(hasSeed ? seed : random_device()());
    uniform_int_distribution<> distribution(smallest, highest);

    // Allocates memory for 'count' number of values.
    randomNumbers.reserve(count);

    while (count-- > 0)
    {
        int randomNumber = distribution(random);

        randomNumbers.push_back(randomNumber);
    }

    return randomNumbers;
}

void clearSeed()
{
    hasSeed = false;
}

void setSeed(long value)
{
    hasSeed = true;
    seed = value;
}

int main(int argc, char* argv[])
{
    int smallest;
    int highest;
    int count;

    if (argc == 4)
    {
        // Reads input from args.
        smallest = atoi(argv[1]);
        highest = atoi(argv[2]);
        count = atoi(argv[3]);
    }
    else
    {
        // Reads input from standard input.
        cout << "What should the smallest integer be?\n> ";
        cin >> smallest;
        cout << "What should the highest integer be?\n> ";
        cin >> highest;
        cout << "How many integers should there be?\n> ";
        cin >> count;
    }

    // Prints the output to standard output.
    // It is recommended for the user to redirect it to a file.
    for (int number : generate(smallest, highest, count))
    {
        cout << number << '\n';
    }

    return 0;
}