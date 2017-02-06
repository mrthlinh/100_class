package gwt;

public class gwt_class_4{

    private ControlPanel cp;
    private FormPanel form = new FormPanel();
    private FileUpload fu =  new FileUpload();

    public gwt_class_4(ControlPanel cp) {
     this.cp = cp;
     this.cp.setPrimaryArea(getFileUploaderWidget());
    }

    @SuppressWarnings("deprecation")
    public Widget getFileUploaderWidget() {
     form.setEncoding(FormPanel.ENCODING_MULTIPART);
     form.setMethod(FormPanel.METHOD_POST);
     // form.setAction(/* WHAT SHOULD I PUT HERE */);

     VerticalPanel holder = new VerticalPanel();

     fu.setName("upload");
     holder.add(fu);
     holder.add(new Button("Submit", new ClickHandler() {
      public void onClick(ClickEvent event) {
       GWT.log("You selected: " + fu.getFilename(), null);
       form.submit();
      }
     }));

     form.addSubmitHandler(new FormPanel.SubmitHandler() {
      public void onSubmit(SubmitEvent event) {
       if (!"".equalsIgnoreCase(fu.getFilename())) {
        GWT.log("UPLOADING FILE????", null);
                                        // NOW WHAT????
       }
       else{
        event.cancel(); // cancel the event
       }

      }
     });

     form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
      public void onSubmitComplete(SubmitCompleteEvent event) {
       Window.alert(event.getResults());
      }
     });

     form.add(holder);

     return form;
    }
}
