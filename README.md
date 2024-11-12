# pmd-issue
Evidence of false positive with PMD 7.7.0
- on-demand import
- private method in lambda

Run
```shell
mvn verify
```
PMD reports
- "Unused import 'java.util.Map.*'." However, the code does not compile without that import
- "Avoid unused private methods such as 'reduceBooksAndLenderStatusByLender'" However, the method is actually used