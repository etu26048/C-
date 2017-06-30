enum Mention
{ NA ("Non admis"), P ("Passable"), AB ("Assez bien"),
	          B ("Bien"), TB ("Tres bien"), NC ("Non connu") ;
  private Mention (String d)
  { mentionDetaillee = d ;
  }
  public String details ()
  { return mentionDetaillee ;
  }
  private String mentionDetaillee ; 
}
