#include <Python.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

typedef struct {
    PyObject_HEAD
    bool is_error;
    const char* error_message;
} ErrorObject;

static void ErrorObject_dealloc(ErrorObject* self) {
    Py_TYPE(self)->tp_free((PyObject*)self);
}

static PyObject* ErrorObject_str(ErrorObject* self) {
    return PyUnicode_FromString(self->error_message);
}

static PyTypeObject ErrorObjectType = {
    PyVarObject_HEAD_INIT(NULL, 0)
    .tp_name = "perfect_pangram_module.ErrorObject",
    .tp_basicsize = sizeof(ErrorObject),
    .tp_dealloc = (destructor)ErrorObject_dealloc,
    .tp_str = (reprfunc)ErrorObject_str,
};

static PyObject* is_perfect_pangram_wrapper(PyObject*, PyObject*);

static PyMethodDef module_methods[] = {
    {"is_perfect_pangram", is_perfect_pangram_wrapper, METH_VARARGS, "Checks if a text is a perfect pangram."},
    {NULL, NULL, 0, NULL}
};

static PyModuleDef module_def = {
    PyModuleDef_HEAD_INIT,
    "perfect_pangram_module",
    NULL,
    -1,
    module_methods
};

PyMODINIT_FUNC PyInit_perfect_pangram_module(void) {
    PyObject* module = PyModule_Create(&module_def);

    if (PyType_Ready(&ErrorObjectType) < 0) {
        return NULL;
    }
    Py_INCREF(&ErrorObjectType);
    PyModule_AddObject(module, "ErrorObject", (PyObject*)&ErrorObjectType);

    return module;
}

static PyObject* is_perfect_pangram_wrapper(PyObject* self, PyObject* args) {
    const char* text;
    if (!PyArg_ParseTuple(args, "s", &text)) {
        return NULL;
    }

    const char* alphabet = "abcdefghijklmnopqrstuvwxyz";
    int alphabet_count[26] = {0};

    ErrorObject* error = PyObject_New(ErrorObject, &ErrorObjectType);
    error->is_error = false;
    error->error_message = NULL;

    for (int i = 0; i < strlen(text); i++) {
        char current_char = tolower(text[i]);

        if (current_char != ' ' && current_char != '.' && current_char != '!' && current_char != '?' && strchr(alphabet, current_char) == NULL) {
            error->is_error = true;
            error->error_message = "Invalid character in the text";
            break;
        }

        if (strchr(alphabet, current_char) != NULL) {
            int index = current_char - 'a';
            alphabet_count[index]++;
        }
    }

    if (!error->is_error) {
        for (int i = 0; i < strlen(alphabet); i++) {
            int index = alphabet[i] - 'a';

            if (alphabet_count[index] != 1) {
                error->is_error = true;
                error->error_message = "Text is not a perfect pangram";
                break;
            }
        }
    }

    return (PyObject*)error;
}
