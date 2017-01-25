#OpenUniversiteit_Le08Demos
Een gui app waarin een [berekening] (https://github.com/simonbosman/OpenUniversiteit/blob/master/Java%20SE%20Introduction/Le08Demos/src/LangeBerekeningFrame.java) in een separate thread wordt uitgevoerd.
Originele voorbeeld maakt gebruikt van een boolean attribuut stoppen om de berekening voortijdig te kunnen beëindigen, dit aangepast in type 
AtomicBoolean vanwege het gegeven dat binnen een multicore architecture elke thread een eigen cache kan hebben.


