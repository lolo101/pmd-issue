# pmd-issue
Evidence of false positive with on-demand import with PMD 7.7.0

Run
```shell
mvn verify
```
PMD reports an "Unused import 'java.util.Map.*'." However, the code does not compile without that import.