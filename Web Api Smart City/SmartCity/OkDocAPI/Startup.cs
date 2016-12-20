using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Owin;
using Owin;
using System.Data.Entity;
using System.Web.Http;
using System.Net.Http.Formatting;
using OkDocAPI.Models;
using Newtonsoft.Json.Serialization;

[assembly: OwinStartup(typeof(OkDocAPI.Startup))]

namespace OkDocAPI
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }

    }
}
