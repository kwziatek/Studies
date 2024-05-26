#pragma once

class LiczbyPierwsze
{
	private:
		bool *tab;
		int N;
	public:
		LiczbyPierwsze(int n);
		~LiczbyPierwsze();
		int liczba(int m);
		void sito();
		
};
