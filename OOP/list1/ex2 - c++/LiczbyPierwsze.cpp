#include<iostream>
#include "LiczbyPierwsze.hpp"

void LiczbyPierwsze::sito()
{
	tab[0] = false;
	tab[1] = false;
	for(int i=2; i<N+1; i++)
	{
		tab[i] = true;
	}
	for(int i=2; i<=N/2; i++)
	{
		if(tab[i] == true)
		{
			for(int j=i*2; j<N+1; j=j+i)
			{
				tab[j] = false;
			}
		}
	}
}

LiczbyPierwsze::LiczbyPierwsze(int n)
{
	tab = new bool[n+1];
	N = n;
}

int LiczbyPierwsze::liczba(int m)
{
	int l=0;
	if(m==0)
		return 0;
	for(int i=2; i<N+1; i++)
	{
		if(tab[i]==true)
		{
			l++;
			if(m==l)
				return i;
		}
	}
	return -1;
}

LiczbyPierwsze::~LiczbyPierwsze()
{
	delete[] tab;
}
