/* Consider telephone book database of N clients. Make use of a
hash table implementation to quickly look up client‘s
telephone number. Make use of two collision handling
techniques and compare them using number of comparisons
required to find a set of telephone numbers/*/

#include <iostream> 
using namespace std; 
 
int main() 
{ 
    int size; 
    cout<<"enter the size of hash table"<<endl; 
    cin>>size;     
    int arr[size],ar1[size];     
    int key,L,no_of_elements,pre; 
    for(int i=0;i<size;i++) 
    {       
      arr[i]=0; 
      ar1[i]=-1; 
    } 
    
    for(int i=0;i<size;i++) 
    {          
      cout<<i<<"\t"<<arr[i]<<"\t"<<ar1[i];       
      cout<<endl; 
    } 
    cout<<"how many elemnts want to store";    
    cin>>no_of_elements;    
    for(int i=0;i<no_of_elements;i++) 
    {        
      cout<<"enter key"; 
      cin>>key; 
        
      int location=key%size; 
      int pre=location; 
        
        
      if(arr[location]==0) 
      {            
        arr[location]=key; 
      }        
      else        
      {              
        while(arr[location]!=0) 
        {                
          location++; 
        } 
        //cout<<"value of location"<<location; 
        arr[location]=key; 
        if(ar1[pre]!=-1)             
        {                 
          int s=ar1[pre];                 
          ar1[s]=location; 
        }             
        else 
        {                 
          ar1[pre]=location; 
        } 
      } 
        
      for(int i=0;i<size;i++) 
      { 
        cout<<i<<"\t"<<arr[i]<<"\t"<<ar1[i];     
        cout<<endl; 
      }        
    }     
    
    return 0; 
  } 
 
