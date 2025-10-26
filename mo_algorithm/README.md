# Mo's algorithm (Java)

This folder contains a simple example implementation of Mo's algorithm in Java.

Files:

- `MoAlgorithm.java` — Example implementation that answers number-of-distinct-values queries on a static integer array using Mo's algorithm (offline queries).

Quick usage example (conceptual):

1. Build your input array `int[] arr`.
2. Create an array of `MoAlgorithm.Query` objects with 0-based inclusive ranges and original indices.
3. Call `int[] answers = MoAlgorithm.mosDistinct(arr, queries);`.

This repository is a general-purpose Java collection of practice problems. The implementation here is intentionally small and dependency-free.
