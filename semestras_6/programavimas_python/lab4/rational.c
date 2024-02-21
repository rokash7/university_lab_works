#include <stdio.h>
#include <stdlib.h>
#include <Python.h>

#include "ratnum.h"

static	ratref simplify(ratref);
static	long int euclid(long int, long int);

/* Define a Python module name */
#define MODULE_NAME "rational"

/* Function declarations */
static PyObject* newrat_wrapper(PyObject*, PyObject*);
static PyObject* showrat_wrapper(PyObject*, PyObject*);
static PyObject* add_wrapper(PyObject*, PyObject*);
static PyObject* addinttorat_wrapper(PyObject*, PyObject*);

/* List of module methods */
static PyMethodDef module_methods[] = {
    {"newrat", newrat_wrapper, METH_VARARGS, "Creates a new rational number."},
    {"showrat", showrat_wrapper, METH_VARARGS, "Prints a rational number."},
    {"__add__", add_wrapper, METH_VARARGS, "Adds two rational numbers."},
    {"addinttorat", addinttorat_wrapper, METH_VARARGS, "Adds an integer to a rational number."},
    {NULL, NULL, 0, NULL} /* Sentinel */
};

/* Module initialization function */
static struct PyModuleDef module_def = {
    PyModuleDef_HEAD_INIT,
    MODULE_NAME,
    NULL,
    -1,
    module_methods
};

/* Module initialization macro */
PyMODINIT_FUNC PyInit_rational(void) {
    return PyModule_Create(&module_def);
}

/* C function wrappers */

static PyObject* newrat_wrapper(PyObject* self, PyObject* args) {
    long int num, den;
    if (!PyArg_ParseTuple(args, "ll", &num, &den)) {
        return NULL;
    }
    ratref r = newrat(num, den);
    return PyLong_FromVoidPtr(r);
}

static PyObject* showrat_wrapper(PyObject* self, PyObject* args) {
    ratref x;
    if (!PyArg_ParseTuple(args, "K", &x)) {
        return NULL;
    }
    showrat(x);
    Py_RETURN_NONE;
}

static PyObject* add_wrapper(PyObject* self, PyObject* args) {
    ratref a, b;
    if (!PyArg_ParseTuple(args, "KK", &a, &b)) {
        return NULL;
    }
    ratref r = __add__(a, b);
    return PyLong_FromVoidPtr(r);
}

static PyObject* addinttorat_wrapper(PyObject* self, PyObject* args) {
    ratref a;
    long int x;
    if (!PyArg_ParseTuple(args, "Kl", &a, &x)) {
        return NULL;
    }
    ratref r = addinttorat(a, x);
    return PyLong_FromVoidPtr(r);
}

/**
 * Sukuria ir inicijuoja naują racionalųjį skaičių.
 *
 * @param num skaitiklis
 * @param den vardiklis
 * @return sukurtas racionalusis skaičius
 */
ratref	newrat(long int num, long int den)
{
	long int	a,b;
	ratref	r;
	r = (ratref) calloc(1, sizeof(struct ratnum));
	r->num = num;
	r->den = den;
	return simplify(r);
}

/**
 * Atspausdina racionalųjį skaičių.
 *
 * @param x racionalusis skaičius
 */
void	showrat(ratref x)
{
	double	rr;
	rr = (double)(x->num)/(double)(x->den);
	fprintf(stderr,"%ld/",x->num);
	fprintf(stderr,"%ld",x->den);
	fprintf(stderr," (%20.10lf)\n",rr);
}

/**
 * Sudeda du racionaluosius skaičius.
 *
 * @param a pirmas racionalusis skaičius
 * @param b antras racionalusis skaičius
 * @return suma
 */
ratref	__add__(ratref a, ratref b)
{
	ratref	r;
	r = simplify(newrat(a->num*b->den + b->num*a->den,a->den*b->den));
	return r;
}

/**
 * Sudeda sveikąjį skaičių prie racinalausjo skaičiaus.
 *
 * @param a racionalusis skaičius
 * @param x sveikasis skaičius
 * @return suma
 */
ratref	addinttorat(ratref a,long int x)
{
	return simplify(newrat(a->num + x * a->den, a->den));
}

/**
 * Supaprastina racionalųjį skaičių.
 *
 * @param a racionalusis skaičius
 * @return supaprastintas racionalusis skaičius
 */
static	ratref	simplify(ratref a)
{
	long int	gcd;
	gcd = euclid(a->num,a->den);
	a->num /= gcd;
	a->den /= gcd;
	return a;
}

/**
 * Skaičiuoja didžiausią bendrą daliklį naudojant Euklido algoritmą.
 *
 * @param a skaičius a
 * @param b skaičius b
 * @return didžiausias bendras daliklis
 */
static	long int	euclid(long int a, long int b)
{
	if(b==0)	return a;
	else		return euclid(b,a%b);
}

/**
 * Lygina du racionaluosius skaičius.
 *
 * @param a pirmas racionalusis skaičius
 * @param b antras racionalusis skaičius
 * @return lyginimo rezultatas
 */
int	ratcomp(ratref *a, ratref *b)
{
	int	rv;
	rv =  (*a)->den*(*b)->num - (*a)->num*(*b)->den;
	return rv;
}