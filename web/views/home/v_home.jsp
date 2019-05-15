<%@page import="DAO.comment_query"%>
<%@page import="model.Comment"%>
<%@page import="model.post"%>
<%@page import="DAO.post_query"%>
<%@page import ="model.User"         %>
<%@page import="DAO.user_dao_query"%>	
<%@page import="DAO.friend_query"%>
<%@page import="java.util.ArrayList"%>
<%
    User us = (User) session.getAttribute("user");
    user_dao_query user_query = new user_dao_query();
    friend_query friend_query = new friend_query();

%>
<main><div class="main-section">
        <div class="container">
            <div class="main-section-data">
                <div class="row">
                    <div class="col-lg-3 col-md-4 pd-left-none no-pd">
                        <div class="main-left-sidebar no-margin">
                            <div class="user-data full-width">
                                <div class="user-profile">
                                    <div class="username-dt">
                                        <div class="usr-pic">
                                            <img src="public/images/resources/user-pic.png" alt="">
                                        </div>
                                    </div><!--username-dt end-->
                                    <div class="user-specs">
                                        <h3><%=us.getUsername()%> </h3>
                                        <span><%=us.getFirst_name()+" " + us.getLast_name()%></span>
                                    </div>
                                </div><!--user-profile end-->
                                <ul class="user-fw-status">
                                    <li>
                                    <h4> <a href="FollowingList"  title="">Following</a> </h4>
                                    <span><%=friend_query.countFollowing(us.getUser_id())%> </span>
                                    </li>
                                    <li>
                                    <h4>Followed</h4>
                                    <span><%=friend_query.countFollowed(us.getUser_id())%></span>
                                    </li>
                                    <li>
                                    <h4>Saved restaurant</h4>
                                    <span>3</span>
                                    </li>

                                    <li>
                                        <a href="UserInfo?userid=<%=us.getUser_id()%>"  title="">View Profile</a>
                                    </li>
                                </ul>
                            </div><!--user-data end-->
                            <!--
                            <div class="suggestions full-width">
                                    <div class="sd-title">
                                            <h3>Suggestions</h3>
                                            <i class="la la-ellipsis-v"></i>
                                    </div>
                                    <div class="suggestions-list">
                                            <div class="suggestion-usd">
                                                    <img src="public/images/resources/s1.png" alt="">
                                                    <div class="sgt-text">
                                                            <h4>Jessica William</h4>
                                                            <span>Graphic Designer</span>
                                                    </div>
                                                    <span><i class="la la-plus"></i></span>
                                            </div>
                                            <div class="suggestion-usd">
                                                    <img src="public/images/resources/s2.png" alt="">
                                                    <div class="sgt-text">
                                                            <h4>John Doe</h4>
                                                            <span>PHP Developer</span>
                                                    </div>
                                                    <span><i class="la la-plus"></i></span>
                                            </div>
                                            <div class="suggestion-usd">
                                                    <img src="public/images/resources/s3.png" alt="">
                                                    <div class="sgt-text">
                                                            <h4>Poonam</h4>
                                                            <span>Wordpress Developer</span>
                                                    </div>
                                                    <span><i class="la la-plus"></i></span>
                                            </div>
                                            <div class="suggestion-usd">
                                                    <img src="public/images/resources/s4.png" alt="">
                                                    <div class="sgt-text">
                                                            <h4>Bill Gates</h4>
                                                            <span>C & C++ Developer</span>
                                                    </div>
                                                    <span><i class="la la-plus"></i></span>
                                            </div>
                                            <div class="suggestion-usd">
                                                    <img src="public/images/resources/s5.png" alt="">
                                                    <div class="sgt-text">
                                                            <h4>Jessica William</h4>
                                                            <span>Graphic Designer</span>
                                                    </div>
                                                    <span><i class="la la-plus"></i></span>
                                            </div>
                                            <div class="suggestion-usd">
                                                    <img src="public/images/resources/s6.png" alt="">
                                                    <div class="sgt-text">
                                                            <h4>John Doe</h4>
                                                            <span>PHP Developer</span>
                                                    </div>
                                                    <span><i class="la la-plus"></i></span>
                                            </div>
                                            <div class="view-more">
                                                    <a href="#" title="">View More</a>
                                            </div>
                                    </div>
                            </div>
                            <div class="tags-sec full-width">
                                    <ul>
                                            <li><a href="#" title="">Help Center</a></li>
                                            <li><a href="#" title="">About</a></li>
                                            <li><a href="#" title="">Privacy Policy</a></li>
                                            <li><a href="#" title="">Community Guidelines</a></li>
                                            <li><a href="#" title="">Cookies Policy</a></li>
                                            <li><a href="#" title="">Career</a></li>
                                            <li><a href="#" title="">Language</a></li>
                                            <li><a href="#" title="">Copyright Policy</a></li>
                                    </ul>
                                    <div class="cp-sec">
                                            <img src="images/logo2.png" alt="">
                                            <p><img src="images/cp.png" alt="">Copyright 2017</p>
                                    </div>
                            </div>
                            -->
                        </div>
                    </div>

                    <div class="col-lg-6 col-md-8 no-pd">
                        <div class="main-ws-sec">

                            <div class="card">
                                <div class="card-header">
                                    <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link active" id="posts-tab" data-toggle="tab" href="#posts" role="tab" aria-controls="posts" aria-selected="true">Write
                                                something
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" id="images-tab" data-toggle="tab" role="tab" aria-controls="images" aria-selected="false" href="#images">Images</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="card-body">
                                    <form method="post" action="addNewPost">
                                        <div class="tab-content" id="myTabContent">

                                            <div class="tab-pane fade show active" id="posts" role="tabpanel" aria-labelledby="posts-tab">
                                                <div class="form-group">
                                                    <label class="sr-only" for="post_tent">post</label>
                                                    <textarea class="form-control" id="post_content" name="post_content" rows="3" placeholder="What are you thinking?"></textarea>
                                                </div>

                                            </div>
                                            <div class="tab-pane fade" id="images" role="tabpanel" aria-labelledby="images-tab">
                                                <div class="form-group">
                                                    <div class="custom-file">
                                                        <input type="file" class="custom-file-input" id="customFile">
                                                        <label class="custom-file-label" for="customFile">Upload image</label>
                                                    </div>
                                                </div>
                                                <div class="py-4"></div>
                                            </div>
                                        </div>
                                        <div class="btn-toolbar justify-content-between">
                                            <div class="btn-group">
                                                <button type="submit" class="btn btn-primary" href="addNewPost">Post</button>
                                            </div>
                                            <div class="btn-group">
                                                <button id="btnGroupDrop1" type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                                                        aria-expanded="false">
                                                    <i class="fa fa-globe"></i>
                                                </button>
                                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="btnGroupDrop1">
                                                    <a class="dropdown-item" href="#"><i class="fa fa-globe"></i> Public</a>
                                                    <a class="dropdown-item" href="#"><i class="fa fa-users"></i> Friends</a>
                                                    <a class="dropdown-item" href="#"><i class="fa fa-user"></i> Just me</a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    </form>

                                </div>
                            </div>
<%
    post_query post_query=new post_query();
    ArrayList<post> PostList= post_query.PostListByUserID(us.getUser_id());
%>
                             <div class="top-profiles">
                                    <div class="pf-hd">
                                        <h3>Top Profiles</h3>
                                        <i class="la la-ellipsis-v"></i>
                                    </div>
                                    <div class="profiles-slider">
                                        <div class="user-profy">
                                            <img src="public/images/resources/user1.png" alt="">
                                            <h3>John Doe</h3>
                                            <span>Graphic Designer</span>
                                            <ul>
                                                <li><a href="#" title="" class="followw">Follow</a></li>
                                                <li><a href="#" title="" class="envlp"><img src="images/envelop.png" alt=""></a></li>
                                                <li><a href="#" title="" class="hire">hire</a></li>
                                            </ul>
                                            <a href="#" title="">View Profile</a>
                                        </div><!--user-profy end-->
                                        <div class="user-profy">
                                            <img src="public/images/resources/user2.png" alt="">
                                            <h3>John Doe</h3>
                                            <span>Graphic Designer</span>
                                            <ul>
                                                <li><a href="#" title="" class="followw">Follow</a></li>
                                                <li><a href="#" title="" class="envlp"><img src="public/images/envelop.png" alt=""></a></li>
                                                <li><a href="#" title="" class="hire">hire</a></li>
                                            </ul>
                                            <a href="#" title="">View Profile</a>
                                        </div><!--user-profy end-->
                                        <div class="user-profy">
                                            <img src="public/images/resources/user3.png" alt="">
                                            <h3>John Doe</h3>
                                            <span>Graphic Designer</span>
                                            <ul>
                                                <li><a href="#" title="" class="followw">Follow</a></li>
                                                <li><a href="#" title="" class="envlp"><img src="public/images/envelop.png" alt=""></a></li>
                                                <li><a href="#" title="" class="hire">hire</a></li>
                                            </ul>
                                            <a href="#" title="">View Profile</a>
                                        </div><!--user-profy end-->
                                        <div class="user-profy">
                                            <img src="public/images/resources/user1.png" alt="">
                                            <h3>John Doe</h3>
                                            <span>Graphic Designer</span>
                                            <ul>
                                                <li><a href="#" title="" class="followw">Follow</a></li>
                                                <li><a href="#" title="" class="envlp"><img src="public/images/envelop.png" alt=""></a></li>
                                                <li><a href="#" title="" class="hire">hire</a></li>
                                            </ul>
                                            <a href="#" title="">View Profile</a>
                                        </div><!--user-profy end-->
                                        <div class="user-profy">
                                            <img src="public/images/resources/user2.png" alt="">
                                            <h3>John Doe</h3>
                                            <span>Graphic Designer</span>
                                            <ul>
                                                <li><a href="#" title="" class="followw">Follow</a></li>
                                                <li><a href="#" title="" class="envlp"><img src="images/envelop.png" alt=""></a></li>
                                                <li><a href="#" title="" class="hire">hire</a></li>
                                            </ul>
                                            <a href="#" title="">View Profile</a>
                                        </div><!--user-profy end-->
                                        <div class="user-profy">
                                            <img src="public/images/resources/user3.png" alt="">
                                            <h3>John Doe</h3>
                                            <span>Graphic Designer</span>
                                            <ul>
                                                <li><a href="#" title="" class="followw">Follow</a></li>
                                                <li><a href="#" title="" class="envlp"><img src="images/envelop.png" alt=""></a></li>
                                                <li><a href="#" title="" class="hire">hire</a></li>
                                            </ul>
                                            <a href="#" title="">View Profile</a>
                                        </div><!--user-profy end-->
                                    </div><!--profiles-slider end-->
                                </div><!--top-profiles end--> 
                            <div class="posts-section">
                                <%for(post pst:PostList){
                                   User usr= user_query.searchUserByUserID(pst.getUser_id());
                                %>
                                <div class="posty">
                                    <div class="post-bar">
                                        <div class="post_topbar">
                                            <div class="usy-dt">
                                                <img src=<%=usr.getAvatar() %> class="avatar" alt="">
                                                <div class="usy-name">
                                                    <h3><%=usr.getUsername() %></h3>
                                                    <span><img src="public/images/clock.png" alt="">3 min ago</span>
                                                </div>
                                            </div>
                                            <div class="ed-opts">
                                                <a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
                                                <ul class="ed-options">
                                                    <li><a href="#" title="">Edit Post</a></li>
                                                    <li><a href="#" title="">Unsaved</a></li>
                                                    <li><a href="#" title="">Unbid</a></li>
                                                    <li><a href="#" title="">Close</a></li>
                                                    <li><a href="#" title="">Hide</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <!--
                                        <div class="epi-sec">
                                                <ul class="descp">
                                                        <li><img src="images/icon8.png" alt=""><span>Epic Coder</span></li>
                                                        <li><img src="images/icon9.png" alt=""><span>India</span></li>
                                                </ul>
                                                <ul class="bk-links">
                                                        <li><a href="#" title=""><i class="la la-bookmark"></i></a></li>
                                                        <li><a href="#" title=""><i class="la la-envelope"></i></a></li>
                                                </ul>
                                        </div>
                                        -->
                                        <div class="food_descp">
                                            <ul class="job-dt">
                                                <!--
                                                <li><a href="#" title="">Full Time</a></li>
                                                -->
                                                <li><span><%=pst.getContent() %></span></li>
                                            </ul>
                                        </div>
                                        <div class="food-img">
                                            <img src=<%=pst.getImage_content() %>>
                                        </div>
                                        <div class="job-status-bar">
                                            <ul class="like-com">
                                                <li>
                                                    <a href="#"><i class="la la-heart"></i> Like</a>
                                                    <img src="public/images/liked-img.png" alt="">
                                                <span>25</span>
                                                </li> 
                                                <li><a href="#" title="" class="com"><img src="public/images/com.png" alt=""> Comment 15</a></li>
                                            </ul>
                                            <a><i class="la la-eye"></i>Views 50</a>
                                        </div>
                                    </div><!--post-bar end-->
                                    
                                    <div class="comment-section">
                                        <div class="plus-ic">
                                            <i class="la la-plus"></i>
                                        </div>
                                        <div class="comment-sec">
                                            <ul>
                                                <li>
                                                    <div class="comment-list">
                                                        <div class="bg-img">
                                                            <img src="public/images/resources/bg-img1.png" alt="">
                                                        </div>
                                                        <div class="comment">
                                                            <h3><John 2></h3>
                                                            <span><img src="public/images/clock.png" alt=""> 3 min ago</span>
                                                            <p>HOSKD</p>
                                                            <a href="#" title="" class="active"><i class="fa fa-reply-all"></i>Reply</a>
                                                        </div>
                                                    </div><!--comment-list end-->
                                                    <ul>
                                                        <li>
                                                            <div class="comment-list">
                                                                <div class="bg-img">
                                                                    <img src="public/images/resources/bg-img2.png" alt="">
                                                                </div>
                                                                <div class="comment">
                                                                    <h3>John Doe</h3>
                                                                    <span><img src="public/images/clock.png" alt=""> 3 min ago</span>
                                                                    <p>Hi John </p>
                                                                    <a href="#" title=""><i class="fa fa-reply-all"></i>Reply</a>
                                                                </div>
                                                            </div><!--comment-list end-->
                                                        </li>
                                                    </ul>
                                                </li>
                                                <li>
                                                    <div class="comment-list">
                                                        <div class="bg-img">
                                                            <img src="public/images/resources/bg-img3.png" alt="">
                                                        </div>
                                                        <div class="comment">
                                                            <h3>John Doe</h3>
                                                            <span><img src="public/images/clock.png" alt=""> 3 min ago</span>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam luctus hendrerit metus, ut ullamcorper quam finibus at.</p>
                                                            <a href="#" title=""><i class="fa fa-reply-all"></i>Reply</a>
                                                        </div>
                                                    </div><!--comment-list end-->
                                                </li>
                                            </ul>
                                        </div><!--comment-sec end-->
                                        <div class="post-comment">
                                            <div class="cm_img">
                                                <img src="public/images/resources/bg-img4.png" alt="">
                                            </div>
                                            <div class="comment_box">
                                                <form action="addComment" method="post">
                                                    <input type="text" name ="comment_content" placeholder="Post a comment">
                                                    <input type="hidden" name ="post_id" value= <%=pst.getPost_id()%> >
                                                    <button type="submit">Send</button>
                                                </form>
                                            </div>
                                        </div><!--post-comment end-->
                                        
                                    </div><!--comment-section end-->
                                </div>
                                <%}%>
                               
                                <div class="process-comm">
                                    <a href="#" title=""><img src="images/process-icon.png" alt=""></a>
                                </div><!--process-comm end-->
                            </div><!--posts-section end-->
                        </div><!--main-ws-sec end-->
                    </div>
                    <div class="col-lg-3 pd-right-none no-pd">
                        <div class="right-sidebar">
                            <div class="widget widget-about">
                                <img src="images/wd-logo.png" alt="">
                                <h3>Track Time on Workwise</h3>
                                <span>Pay only for the Hours worked</span>
                                <div class="sign_link">
                                    <h3><a href="#" title="">Sign up</a></h3>
                                    <a href="#" title="">Learn More</a>
                                </div>
                            </div><!--widget-about end-->
                            <div class="widget widget-jobs">
                                <div class="sd-title">
                                    <h3>Top Jobs</h3>
                                    <i class="la la-ellipsis-v"></i>
                                </div>
                                <div class="jobs-list">
                                    <div class="job-info">
                                        <div class="job-details">
                                            <h3>Senior Product Designer</h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                        </div>
                                        <div class="hr-rate">
                                            <span>$25/hr</span>
                                        </div>
                                    </div><!--job-info end-->
                                    <div class="job-info">
                                        <div class="job-details">
                                            <h3>Senior UI / UX Designer</h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                        </div>
                                        <div class="hr-rate">
                                            <span>$25/hr</span>
                                        </div>
                                    </div><!--job-info end-->
                                    <div class="job-info">
                                        <div class="job-details">
                                            <h3>Junior Seo Designer</h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                        </div>
                                        <div class="hr-rate">
                                            <span>$25/hr</span>
                                        </div>
                                    </div><!--job-info end-->
                                    <div class="job-info">
                                        <div class="job-details">
                                            <h3>Senior PHP Designer</h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                        </div>
                                        <div class="hr-rate">
                                            <span>$25/hr</span>
                                        </div>
                                    </div><!--job-info end-->
                                    <div class="job-info">
                                        <div class="job-details">
                                            <h3>Senior Developer Designer</h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                        </div>
                                        <div class="hr-rate">
                                            <span>$25/hr</span>
                                        </div>
                                    </div><!--job-info end-->
                                </div><!--jobs-list end-->
                            </div><!--widget-jobs end-->
                            <div class="widget widget-jobs">
                                <div class="sd-title">
                                    <h3>Most Viewed This Week</h3>
                                    <i class="la la-ellipsis-v"></i>
                                </div>
                                <div class="jobs-list">
                                    <div class="job-info">
                                        <div class="job-details">
                                            <h3>Senior Product Designer</h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                        </div>
                                        <div class="hr-rate">
                                            <span>$25/hr</span>
                                        </div>
                                    </div><!--job-info end-->
                                    <div class="job-info">
                                        <div class="job-details">
                                            <h3>Senior UI / UX Designer</h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                        </div>
                                        <div class="hr-rate">
                                            <span>$25/hr</span>
                                        </div>
                                    </div><!--job-info end-->
                                    <div class="job-info">
                                        <div class="job-details">
                                            <h3>Junior Seo Designer</h3>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                        </div>
                                        <div class="hr-rate">
                                            <span>$25/hr</span>
                                        </div>
                                    </div><!--job-info end-->
                                </div><!--jobs-list end-->
                            </div><!--widget-jobs end-->
                            <div class="widget suggestions full-width">
                                <div class="sd-title">
                                    <h3>Most Viewed People</h3>
                                    <i class="la la-ellipsis-v"></i>
                                </div><!--sd-title end-->
                                <div class="suggestions-list">
                                    <div class="suggestion-usd">
                                        <img src="public/images/resources/s1.png" alt="">
                                        <div class="sgt-text">
                                            <h4>Jessica William</h4>
                                            <span>Graphic Designer</span>
                                        </div>
                                        <span><i class="la la-plus"></i></span>
                                    </div>
                                    <div class="suggestion-usd">
                                        <img src="public/images/resources/s2.png" alt="">
                                        <div class="sgt-text">
                                            <h4>John Doe</h4>
                                            <span>PHP Developer</span>
                                        </div>
                                        <span><i class="la la-plus"></i></span>
                                    </div>
                                    <div class="suggestion-usd">
                                        <img src="public/images/resources/s3.png" alt="">
                                        <div class="sgt-text">
                                            <h4>Poonam</h4>
                                            <span>Wordpress Developer</span>
                                        </div>
                                        <span><i class="la la-plus"></i></span>
                                    </div>
                                    <div class="suggestion-usd">
                                        <img src="public/images/resources/s4.png" alt="">
                                        <div class="sgt-text">
                                            <h4>Bill Gates</h4>
                                            <span>C &amp; C++ Developer</span>
                                        </div>
                                        <span><i class="la la-plus"></i></span>
                                    </div>
                                    <div class="suggestion-usd">
                                        <img src="public/images/resources/s5.png" alt="">
                                        <div class="sgt-text">
                                            <h4>Jessica William</h4>
                                            <span>Graphic Designer</span>
                                        </div>
                                        <span><i class="la la-plus"></i></span>
                                    </div>
                                    <div class="suggestion-usd">
                                        <img src="public/images/resources/s6.png" alt="">
                                        <div class="sgt-text">
                                            <h4>John Doe</h4>
                                            <span>PHP Developer</span>
                                        </div>
                                        <span><i class="la la-plus"></i></span>
                                    </div>
                                    <div class="view-more">
                                        <a href="#" title="">View More</a>
                                    </div>
                                </div><!--suggestions-list end-->
                            </div>
                        </div><!--right-sidebar end-->
                    </div>
                </div>
            </div><!-- main-section-data end-->
        </div> 
    </div>
</main>