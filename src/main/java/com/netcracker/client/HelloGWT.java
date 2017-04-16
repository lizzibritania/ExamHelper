package main.java.com.netcracker.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import main.java.com.netcracker.shared.Exam;
import java.util.List;

public class HelloGWT implements EntryPoint {
    public final CellTable<Exam> table = new CellTable<Exam>();
    public int pager = 0;
    public int listlenght = 0;
    public VerticalPanel verticalPanel = new VerticalPanel();
  
    
    public Exam newstop = new Exam("1", "2", "3", "4", "4","4");

    public List<Exam> ExamList;
    VerticalPanel deleteExam = new VerticalPanel();
    public void onModuleLoad() {
        final ExamServiceAsync createService = GWT.create(ExamService.class);
        final ExamServiceAsync fornew = GWT.create(ExamService.class);
        final AsyncCallback<List<Exam>> sorter= new AsyncCallback<List<Exam>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Sorting Failed");
            }

            @Override
            public void onSuccess(List<Exam> result) {
                List <Exam> sortedList = result;
                ListDataProvider<Exam> dataProvider = new ListDataProvider<Exam>();
                dataProvider.addDataDisplay(table);
                List<Exam> list = dataProvider.getList();
                for (Exam Exam : sortedList ) {
                    list.add(Exam);
                    table.redraw();

                }
            }
        };

        final AsyncCallback<List<Exam>> callback = new AsyncCallback<List<Exam>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Table with Exams not found");
            }

            @Override
            public void onSuccess(List<Exam> result) {
                if (result == null) {
                    Window.alert("Error in database");
                } else {
                    ExamList = result;
                    TextColumn<Exam> GroupColumn = new TextColumn<Exam>() {
                        @Override
                        public String getValue(Exam Exam) {
                            return Exam.getGroup();
                        }
                    };
                    GroupColumn.setSortable(true);
                    TextColumn<Exam> SubjectColumn = new TextColumn<Exam>() {
                        @Override
                        public String getValue(Exam Exam) {
                            return Exam.getSubject();
                        }
                    };
                    SubjectColumn.setSortable(true);
                    TextColumn<Exam> DateColumn = new TextColumn<Exam>() {
                        @Override
                        public String getValue(Exam Exam) {
                            return Exam.getDate();
                        }
                    };
                    DateColumn.setSortable(true);
                    TextColumn<Exam> TimeColumn = new TextColumn<Exam>() {
                        @Override
                        public String getValue(Exam Exam) {
                            return Exam.getTime();
                        }
                    };
                    TimeColumn.setSortable(true);

                    TextColumn<Exam> RoomColumn = new TextColumn<Exam>() {
                        @Override
                        public String getValue(Exam Exam) {
                            return Exam.getRoom();
                        }
                    };
                    RoomColumn.setSortable(true);

                    TextColumn<Exam> TeacherColumn = new TextColumn<Exam>() {
                        @Override
                        public String getValue(Exam Exam) {
                            return Exam.getTeacher();
                        }
                    };
                    TeacherColumn.setSortable(true);
                    ListDataProvider<Exam> dataProvider = new ListDataProvider<Exam>();
                    dataProvider.addDataDisplay(table);
                    List<Exam> list = dataProvider.getList();
                    for (Exam Exam : ExamList) {
                        list.add(Exam);
                        listlenght += 1;
                    }
                    table.addColumn(GroupColumn, "Group");
                    table.addColumn(SubjectColumn, "Subject");
                    table.addColumn(DateColumn, "Date");
                    table.addColumn(TimeColumn, "Time");
                    table.addColumn(RoomColumn, "Room");
                    table.addColumn(TeacherColumn, "Teacher");
                    table.setVisibleRange(0, 10);
                    table.addColumnStyleName(0, "GroupColumn");
                    table.addColumnStyleName(0, "SubjectColumn");

                    Button sortByG = new Button("Sort by Group", new ClickHandler() {
                        public void onClick(ClickEvent event) {
                        }
                    });


                    Button sortByS = new Button("Sort by subject", new ClickHandler() {
                        public void onClick(ClickEvent event) {

                        }
                    });

                    Button sortByD = new Button("Sort by date", new ClickHandler() {
                        public void onClick(ClickEvent event) {

                        }
                    });

                    Button sortByT = new Button("Sort by time", new ClickHandler() {
                        public void onClick(ClickEvent event) {

                        }
                    });
                    Button sortByR = new Button("Sort by room", new ClickHandler() {
                        public void onClick(ClickEvent event) {

                        }
                    });
                    Button sortByTe = new Button("Sort by teacher", new ClickHandler() {
                        public void onClick(ClickEvent event) {

                        }
                    });

                    HorizontalPanel sort = new HorizontalPanel();
                    sort.add(sortByG);
                    sort.add(sortByS);
                    sort.add(sortByD);
                    sort.add(sortByT);
                    sort.add(sortByR);
                    sort.add(sortByTe);
                    RootPanel.get().add(sort);
                    RootPanel.get().add(table);

                    Button prev = new Button("Previous page", new ClickHandler() {
                        public void onClick(ClickEvent event) {
                            if (pager != 0) {
                                pager -= 10;
                            }
                            table.setVisibleRange(pager, 10);
                        }
                    });

                    Button next = new Button("Next page", new ClickHandler() {
                        public void onClick(ClickEvent event) {
                            if ((listlenght > pager+10)){
                                pager += 10;
                                table.setVisibleRange(pager, 10);
                            }


                        }
                    });

                    RootPanel.get().add(prev);
                    RootPanel.get().add(next);
                    Button newexam = new Button("Add new Exam", new ClickHandler() {
                        public void onClick(ClickEvent event) {
                            verticalPanel.setVisible(true);
                        }
                    });


                    Button add = new Button("Add Exam", new ClickHandler() {
                        public void onClick(ClickEvent event) {

                            final AsyncCallback<Void> adder = new AsyncCallback<Void>() {
                                @Override
                                public void onFailure(Throwable caught) {
                                    Window.alert("Something went wrong, exam not added");
                                }

                                @Override
                                public void onSuccess(Void result) {
                                    Window.alert("Exam added ");
                                    ListDataProvider<Exam> dataProvider = new ListDataProvider<Exam>();
                                    dataProvider.addDataDisplay(table);
                                    List<Exam> list = dataProvider.getList();
                                    for (Exam Exam : ExamList) {
                                        list.add(Exam);
                                        table.redraw();
                                    }
                                }
                            };


                           // fornew.addNewExam(newstop, adder);
                        }
                    });

                 Button   close = new Button("Close", new ClickHandler() {
                        public void onClick(ClickEvent event) {
                            verticalPanel.setVisible(false);
                        }
                    });
                    HorizontalPanel fornewExam = new HorizontalPanel();
                    fornewExam.add(add);
                    fornewExam.add(close);
                    verticalPanel.add(fornewExam);


                    RootPanel.get().add(verticalPanel);
                    verticalPanel.setVisible(false);

                    Button delete = new Button("Delete Exam by subject", new ClickHandler() {
                        public void onClick(ClickEvent event) {
                            deleteExam.setVisible(true);
                        }
                    });
                    RootPanel.get().add(delete);
                  //  delete.setStyleName("button");
                    Label ExamNum = new Label("Please enter Exam  that you would like to delete");
                //    ExamNumb = new TextBox();
                    deleteExam.add(ExamNum);
                 //   deleteExam.add(ExamNumb);
                    HorizontalPanel fordel = new HorizontalPanel();

                    Button del = new Button("Delete Exam", new ClickHandler() {
                        public void onClick(ClickEvent event) {
                            final AsyncCallback<Void> eraser = new AsyncCallback<Void>() {
                                @Override
                                public void onFailure(Throwable caught) {
                                    Window.alert("Something went wrong, Exam not found");
                                }

                                @Override
                                public void onSuccess(Void result) {
                                    Window.alert("Exam deleted ");
                                    table.redraw();
                                }
                            };
                          //  fornew.deleteExam(ExamNumb.getText(), eraser);
                        }
                    });
                    Button closedel = new Button("Close", new ClickHandler() {
                        public void onClick(ClickEvent event) {
                            deleteExam.setVisible(false);
                        }
                    });

                    fordel.add(del);
                    fordel.add(closedel);
                    deleteExam.add(fordel);
                    RootPanel.get().add(deleteExam);
                    deleteExam.setVisible(false);
                }
            }
        };


        createService.getExams(callback);

    }


}