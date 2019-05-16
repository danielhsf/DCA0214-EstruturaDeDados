#include <bits/stdc++.h> 
using namespace std; 
  
void towerOfHanoi(int n, char from_rod, 
                    char to_rod, char aux_rod)  
{  
    if (n == 1)  
    {  
        cout << "Mover disco 1 do pino " << from_rod <<  
                            " para o pino " << to_rod<<endl;  
        return;  
    }  
    towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);  
    cout << "Mover disco " << n << " do pino " << from_rod << 
                                " para o pino " << to_rod << endl;  
    towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);  
}  
  
// Driver code 
int main()  
{  
    int n = 3; // Number of disks  
    towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods  
    return 0;  
}  