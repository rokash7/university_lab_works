struct	ratnum
{
	long	int	num;
	long	int	den;
};

typedef	struct	ratnum	* ratref;

ratref	newrat(long int,long int);
void	showrat(ratref);
ratref	__add__(ratref,ratref);
ratref	addinttorat(ratref,long int);
int	ratcomp(ratref *,ratref *);