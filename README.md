

# Kiểm tra đạo mã nguồn
[![CI Build](https://github.com/jplag/jplag/actions/workflows/maven.yml/badge.svg)](https://github.com/jplag/jplag/actions/workflows/maven.yml)
[![GitHub commit activity](https://img.shields.io/github/commit-activity/y/jplag/JPlag)](https://github.com/jplag/JPlag/pulse)
[![Report Viewer](https://img.shields.io/badge/report%20viewer-online-b80025)](https://jplag.github.io/JPlag/)
[![Java Version](https://img.shields.io/badge/java-SE%2017-yellowgreen)](#download-and-installation)



## Supported Languages
Sử dụng chương trình: java -jar plagiarism-detector.jar -l [ngôn ngữ] -r [thư mục chứa bài code] -x [thư mục chứa file result]
Sau khi chạy sẽ tạo file result trong cùng thư mục với file plagiarism-detector.jar 

| Ngôn Ngữ                                              | Version | CLI Argument Name |
|--------------------------------------------------------|--------:|-------------------|
| [Java](https://www.java.com)                           |      17 | java              |
| [C/C++](https://isocpp.org)                            |      11 | cpp               |
| [C/C++](https://isocpp.org)                            |      14 | cpp2              |
| [C#](https://docs.microsoft.com/en-us/dotnet/csharp/)  |       8 | csharp            |
| [Go](https://go.dev)                                   |    1.17 | golang            |
| [Kotlin](https://kotlinlang.org)                       |     1.3 | kotlin            |
| [Python](https://www.python.org)                       |     3.6 | python3           |
| Text (naive)                                           |       - | text              |

## Cài Dặt
Sử dụng java 17 và maven


### Building from sources 
1. Tải hoặc clone thừ repository này về.
2. Run `mvn clean package` từ thư mục gốc của dự án để chạy toàn bộ chương trình,
   Run `mvn clean package assembly:single` từ thư mục gốc để đóng gói file jar.
Sau khi chạy thì sẽ thấy plagiarism-detector.jar trong thư mục `cli/target`.

Các chức năng:
Màn hình chính
![image](https://github.com/dinhnguyen1812002/plagiarism-detector/assets/88964296/9a2ec160-ee06-4b51-aac7-224cbff1cd4d)



[//]: # (```)

[//]: # (positional arguments:)

[//]: # (  rootDir                Root-directory with submissions to check for plagiarism)

[//]: # ()
[//]: # (named arguments:)

[//]: # (  -h, --help             show this help message and exit)

[//]: # (  -new NEW [NEW ...]     Root-directory with submissions to check for plagiarism &#40;same as the root directory&#41;)

[//]: # (  -old OLD [OLD ...]     Root-directory with prior submissions to compare against)

[//]: # (  -l {cpp,csharp,emf,go,java,kotlin,python3,rlang,rust,scala,scheme,swift,text})

[//]: # (                         Select the language to parse the submissions &#40;default: java&#41;)

[//]: # (  -bc BC                 Path of  the  directory  containing  the  base  code  &#40;common  framework  used  in  all)

[//]: # (                         submissions&#41;)

[//]: # (  -t T                   Tunes the comparison sensitivity by adjusting the  minimum token required to be counted)

[//]: # (                         as a matching section. A smaller <n>  increases  the sensitivity but might lead to more)

[//]: # (                         false-positives)

[//]: # (  -n N                   The maximum number of comparisons that will  be  shown  in the generated report, if set)

[//]: # (                         to -1 all comparisons will be shown &#40;default: 100&#41;)

[//]: # (  -r R                   Name of the directory in which the comparison results will be stored &#40;default: result&#41;)

[//]: # ()
[//]: # (Advanced:)

[//]: # (  -d                     Debug parser. Non-parsable files will be stored &#40;default: false&#41;)

[//]: # (  -s S                   Look in directories <root-dir>/*/<dir> for programs)

[//]: # (  -p P                   comma-separated list of all filename suffixes that are included)

[//]: # (  -x X                   All files named in this file will be ignored in the comparison &#40;line-separated list&#41;)

[//]: # (  -m M                   Comparison similarity threshold [0.0-1.0]:  All  comparisons  above this threshold will)

[//]: # (                         be saved &#40;default: 0.0&#41;)

[//]: # ()
[//]: # (Clustering:)

[//]: # (  --cluster-skip         Skips the clustering &#40;default: false&#41;)

[//]: # (  --cluster-alg {AGGLOMERATIVE,SPECTRAL})

[//]: # (                         Which clustering algorithm to use. Agglomerative  merges similar submissions bottom up.)

[//]: # (                         Spectral clustering is  combined  with  Bayesian  Optimization  to  execute the k-Means)

[//]: # (                         clustering  algorithm  multiple   times,   hopefully   finding   a   "good"  clustering)

[//]: # (                         automatically. &#40;default: spectral&#41;)

[//]: # (  --cluster-metric {AVG,MIN,MAX,INTERSECTION})

[//]: # (                         The metric used for clustering. AVG  is  intersection  over  union, MAX can expose some)

[//]: # (                         attempts of obfuscation. &#40;default: MAX&#41;)

[//]: # (```)

[//]: # (### Java API)

[//]: # ()
[//]: # (The new API makes it easy to integrate JPlag's plagiarism detection into external Java projects:)

[//]: # ()
[//]: # (<!-- To assure that the code example is always correct, it must be kept in sync)

[//]: # (with [`ReadmeCodeExampleTest#testReadmeCodeExample`]&#40;core/src/test/java/de/jplag/special/ReadmeCodeExampleTest.java&#41;. -->)

[//]: # (```java)

[//]: # (Language language = new de.jplag.java.Language&#40;&#41;;)

[//]: # (Set<File> submissionDirectories = Set.of&#40;new File&#40;"/path/to/rootDir"&#41;&#41;;)

[//]: # (File baseCode = new File&#40;"/path/to/baseCode"&#41;;)

[//]: # (JPlagOptions options = new JPlagOptions&#40;language, submissionDirectories, Set.of&#40;&#41;&#41;.withBaseCodeSubmissionDirectory&#40;baseCode&#41;;)

[//]: # ()
[//]: # (JPlag jplag = new JPlag&#40;options&#41;;)

[//]: # (try {)

[//]: # (    JPlagResult result = jplag.run&#40;&#41;;)

[//]: # (     )
[//]: # (    // Optional)

[//]: # (    ReportObjectFactory reportObjectFactory = new ReportObjectFactory&#40;&#41;;)

[//]: # (    reportObjectFactory.createAndSaveReport&#40;result, "/path/to/output"&#41;;)

[//]: # (} catch &#40;ExitException e&#41; {)

[//]: # (    // error handling here)

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (## Contributing)

[//]: # (We're happy to incorporate all improvements to JPlag into this codebase. Feel free to fork the project and send pull requests.)

[//]: # (Please consider our [guidelines for contributions]&#40;https://github.com/jplag/JPlag/wiki/3.-Contributing-to-JPlag&#41;.)

[//]: # ()
[//]: # (## Contact)

[//]: # (If you encounter bugs or other issues, please report them [here]&#40;https://github.com/jplag/jplag/issues&#41;.)

[//]: # (For other purposes, you can contact us at jplag@ipd.kit.edu .)

[//]: # (If you are doing research related to JPlag, we would love to know what you are doing. Feel free to contact us!)

[//]: # ()
[//]: # (### More information can be found in our [Wiki]&#40;https://github.com/jplag/JPlag/wiki&#41;!)
