import java.util.Scanner;

public class Insertion 
{
	int  a[], size;
	
	Scanner sc = new Scanner(System.in);
	
	void createArray(int size)
	{
		a = new int[size];
		
		this.size = size;
		
		System.out.println("Enter Data: ");
		
		for(int i = 0 ; i < size; i++)
		{
			a[i] = sc.nextInt();
		}
	}
	
	void InsertionSort()
	{
		int i,j,newelement;
		for(i=0;i<size-1;i++)
		{
			newelement=a[i+1];
			j=i+1;
			while(j>0 && newelement<a[j-1])
			{
				a[j]=a[j-1];
				j--;
			}
			a[j]=newelement;
		}
	}
	
	public void printArray()
	{
		 System.out.println("Sorted Array is :");
		 for(int i=0;i<a.length;i++)
			 System.out.println(a[i]);
	}
	
	public static void main(String[] args) 
	{
		int size;
		Insertion s=new Insertion();
		System.out.println("Enter Array Size: ");
		Scanner sc=new Scanner(System.in);
		size=sc.nextInt();
		s.createArray(size);
		s.InsertionSort();
		s.printArray();

	}

}
