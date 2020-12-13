### Hinge Patterns

<p align="center">
  <a href="https://github.com/mycaule/hinge_patterns/actions"><img src="https://github.com/mycaule/hinge_patterns/workflows/Scala%20CI/badge.svg?branch=main" alt="Build Status"></a>
  <br>
  <br>
</p>

<div align="center">
  <img src="https://pbs.twimg.com/media/Eoz1b5dWMAYLdSy?format=png" width=500>
</div>

Compare ASCII encoding and Hinge encoding.

```sh
$ sbt run

A: ArraySeq(65)
   ArraySeq(List(1, 0, 0, 0, 1, 0, 2, 0, 1, 0, 0, 3, 0, 0, 4, 0, 2))
B: ArraySeq(66)
   ArraySeq(List(1, 0, 0, 0, 1, 0, 2, 0, 1, 0, 0, 3, 0, 1, 0, 2, 0, 0))
C: ArraySeq(67)
   ArraySeq(List(0, 1, 0, 2, 0, 0, 0, 0, 1, 0, 2, 0))
Hello: ArraySeq(72, 101, 108, 108, 111)
   ArraySeq(List(1, 0, 0, 0, 3, 0, 1, 0, 2, 0, 0, 3, 0, 0, 0, 0, 2), List(0, 0, 2, 0, 1, 0, 0, 3, 0, 1, 0, 2, 0, 0), List(0, 0, 0, 0, 0, 4, 3, 0, 0), List(0, 0, 0, 0, 0, 4, 3, 0, 0), List(0, 0, 0, 1, 0, 2, 0, 0, 0, 1, 0, 2))
1: ArraySeq(49)
   ArraySeq(List(0, 5, 0, 0, 0, 0, 5, 2))
2: ArraySeq(50)
   ArraySeq(List(0, 0, 1, 0, 2, 0, 2, 0, 1, 0, 0))
3: ArraySeq(51)
   ArraySeq(List(0, 0, 2, 0, 1, 0, 0, 3, 0, 1, 0, 2, 0, 0))
42: ArraySeq(52, 50)
   ArraySeq(List(1, 0, 2, 0, 2, 0, 0, 3, 0, 1, 0, 2, 0, 0, 3, 0, 0, 0, 2), List(0, 0, 1, 0, 2, 0, 2, 0, 1, 0, 0))
```

For example,
```scala
// letter 1 needs 8 folds using 0, 2, 5
Seq(0, 5, 0, 0, 0, 0, 5, 2)

// letter X needs 22 folds using 0, 1, 2, 3.
Seq(1, 1, 1, 0, 2, 2, 0, 3, 1, 1, 1, 2, 2, 2, 0, 3, 1, 1, 0, 2, 2, 2)
```

#### References

- [Nadia Benbernou et al. - Universal Hinge Patterns for Folding Strips Efficiently into Any Grid Polyhedron](http://erikdemaine.org/papers/StripsGrid_WADS2017/paper.pdf)
- [Erik Demaine - Strip Folding Font](http://erikdemaine.org/fonts/strip/)
- [Roger Mansuy's tweet](https://twitter.com/roger_mansuy/status/1336713975548014592)
- Similar to the mower problem in [`mycaule/bb-assessment`](https://github.com/mycaule/bb-assessment)
