```
██████╗ ███████╗██████╗ ██╗   ██╗███╗   ███╗
██╔══██╗██╔════╝██╔══██╗██║   ██║████╗ ████║
██████╔╝█████╗  ██████╔╝██║   ██║██╔████╔██║
██╔══██╗██╔══╝  ██╔══██╗██║   ██║██║╚██╔╝██║
██║  ██║███████╗██║  ██║╚██████╔╝██║ ╚═╝ ██║
╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚═╝
```
reconditorium eximium rerum universalium mutabiliumque

RERUM is a product of the Center for Digital Humanities at Saint Louis
        University and is (currently) completely funded and maintained by the
        fine folks on their retirement plan. This site is meant to be used by
        developers and programmers who need a good place to put some data and
        prefer that it be a public place that is not too expensive.
        
Our goal is to provide a simple, out-of-the box connection that reduces
        concerns and costs about data storage and management while making
        interoperability, standards compliance, and attribution automatic.
        
Originally conceived as a "IIIF Store" (iiif.io), RERUM is designed to act as an
open node for annotation and references that need to be made in an interoperable
world of scholarly assertions.

This project is not only access to the existing instance, created by the
Center for Digital Humanities and hosted by Saint Louis University, but
also the complete cut list for making your own. However useful this may be for private
projects, applications in development, or because of funding requirements, we
hope that your machine enjoys talking to others and releases its gnats of
knowledge into the Interwebs.

RERUM Install Information
To use your own instance RERUM, here are a few things to know:

   - RERUM will work with any server, we have implemented on a Linux system with RedHat. 
   - Java 6+
   - The datbasing software used in MongoDB since all entries in the DB are JSON blobs.
   - min 3GB HD space
   - RERUM uses HTTP protocols to do CRUD operations from the client.  
   - HTTP GET requests must be open on port 80
   
