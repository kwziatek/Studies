#include<iostream>
#include<string>
#include "LiczbyPierwsze.hpp"

int main(int argc, char* argv[])
{
	LiczbyPierwsze *t;
	int m=0;
	try
	{
		m=std::stoi(argv[1]);
		t = new LiczbyPierwsze(m);
		t->sito();
		for(int i=2; i<argc; i++)
		{
			try 
			{
				m = std::stoi(argv[i]);
				if(t->liczba(m)==-1)
				{
					std::cout<<argv[i]<<" poza zakresem."<<std::endl;
				}
				else if(t->liczba(m)==0)
				{
					std::cout<<argv[i]<<" liczymy od 1."<<std::endl;
				}
				else
				{
					std::cout<<argv[i]<<"  "<<t->liczba(m)<<std::endl;
				}
			}
			catch(...)
			{
				std::cout<<argv[i]<<"  zle dane."<<std::endl;
			}
		}
	}
	catch(...)
	{
		std::cout<<"zle dane"<<std::endl;
	}
}
