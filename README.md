# Virtual Textual Model Composition for Supporting Versioning and Aspect-Orientation
![Logo](http://virtualedit.big.tuwien.ac.at/img/VirtualEditLogo_220x220.png)

The maintenance of modern systems often requires developers to perform complex and error-prone cognitive tasks, which are caused by the obscurity, redundancy, and irrelevancy of code, distracting from essential maintenance tasks.

Typical maintenance scenarios include multiple branches of code in repositories, which involves dealing with branch-interdependent changes, and aspects in aspect-oriented programming, which requires in-depth knowledge of behavior-interdependent changes. Thus, merging branched files as well as validating the behavior of statically composed code requires developers to conduct exhaustive individual introspection.

In this work we present the VirtualEdit for associative, commutative, and invertible model composition that enables simultaneous editing of multiple model versions or variants through dynamically derived virtual models. We implemented the approach in terms of an open-source framework that enables the maintenance of multi-versioned and aspect-oriented software through selective focus on specific parts of code, which are significant for a particular maintenance task.

The VirtualEdit framework is evaluated based on its application to the most popular publicly available Xtext-based languages. Our results indicate that our approach is surprisingly easy to include in other languages and can be used in a prototypical fashion.

See also [VirtualEdit Project Website](http://virtualedit.big.tuwien.ac.at).

#### Dependencies

[XMLIntelledit](http://xmlintelledit.big.tuwien.ac.at)
[Intelledit](http://intelledit.big.tuwien.ac.at)

#### How to run 

You can obtain the latest version of VirtualEdit by directly downloading the VirtualEdit project archive file or clone the VirtualEdit GitHub repository, the IntellEdit project archive file or clone the IntellEdit GitHub repository and the the XMLIntelledit project archive file or clone the XMLIntelledit GitHub repository.

Watch VirtualEdit in action by proceeding with the following simple steps:

- Recommended: Clean Eclipse workspace.
- Recommended: Right-click on "at.ac.tuwien.big.simplejava/model/generated/Simplejava.ecore" and register the package.
- Create an empty src and xtend-gen folder in each *.ide project.
- Run an Eclipse runtime application, i.e., a second Eclipse instance started by your initial Eclipse instance, by right-clicking on any imported plugin project in the package explorer and select "Run As > Eclipse Application".
Ignore the project errors for now.
- Within the Eclipse runtime application, import the project TestBank of the VirtualEdit-Git.
Sometimes, you may need to copy the content of the .basic-file into the .vjava-file and delete the .basic file if something breaks.
- Try out the virtual textual model composition !
- Note that aspects are re-executed as soon as file changes have been saved.

#### External Resources

* Our prototype builds on the [Eclipse Modeling Framework](https://eclipse.org/modeling/emf/) and the [Xtext framework](https://eclipse.org/Xtext/) 
