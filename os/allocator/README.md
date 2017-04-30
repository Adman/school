allocator
=========

alloc.c is a part of bigger program, which I did not wrote. Therefore,
I've just uploaded this module, which takes care of allocating and deallocating
memory.

* my_init - called when memory is created.
* my_alloc(size) - tries to allocate `size` bytes and returns pointer to the first one.
In case there is no such space to be allocated, it returns `FAIL`.
* my_free(addr) - frees memory starting at `addr`. If successfuly freed, it returns
`OK` status, otherwise `FAIL`
